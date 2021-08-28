package com.thuctapcdit.qlnguyenlieube.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thuctapcdit.qlnguyenlieube.dao.MaterialRepository;
import com.thuctapcdit.qlnguyenlieube.dao.ProductMaterialRepo;

import com.thuctapcdit.qlnguyenlieube.dao.ProductRepository;
import com.thuctapcdit.qlnguyenlieube.dao.UserRepo;

import com.thuctapcdit.qlnguyenlieube.dto.ProductDto;
import com.thuctapcdit.qlnguyenlieube.dto.MaterialDto;
import com.thuctapcdit.qlnguyenlieube.exception.NotFoundException;
import com.thuctapcdit.qlnguyenlieube.model.*;
import com.thuctapcdit.qlnguyenlieube.service.AlertService;
import com.thuctapcdit.qlnguyenlieube.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.InvalidParameterException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMaterialRepo pmRepo;

    @Autowired
    private MaterialRepository materialRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;
    
    @Autowired
    private ObjectMapper objectMapper;

//    @Autowired
//    private FileStorageService fileStorageService;

    @Autowired
    private AlertService alertService;

    @Override
    public List<ProductDto> getProductsByName(Integer page, Integer size, String name, Integer status) {
        Pageable pageable = PageRequest.of(page, size);

        if(status == null){
            Page<Product> list = productRepository
                    .findByNameLikeOrderByUpdatedAtDesc("%"+name+"%" , pageable);

            return converseMaterialToDto(list);
        }
        Page<Product> list = productRepository
                .findByNameLikeAndStatusOrderByUpdatedAtDesc("%"+name+"%" , status, pageable);

        return converseMaterialToDto(list);
    }

    @Override
    @Transactional
    public ProductDto createProduct(ProductDto productDto, Long userId) throws JsonProcessingException {
        List list = objectMapper.readValue(productDto.getMaterialsJSON() , List.class);

       // String fileName = fileStorageService.storeFile(productDto.getFile() , false);

        Product product = modelMapper.map(productDto , Product.class);
        product.setStatus(1);
        //product.setImage(fileName);
        User user = userRepo.getById(userId);
        product.setUser(user);

        List<Map<String , Object>> listMaterialDto = new ArrayList<>();

        list.forEach(item -> {
            listMaterialDto.add((Map<String, Object>) item);
        });



        Product response = productRepository.save(product);

        listMaterialDto.forEach(i -> {

            String nameMat = (String) i.get("name");
            Float amountMa = Float.parseFloat((String) i.get("amountMaterial")) ;


            Material s = materialRepo.findByName(nameMat).orElseThrow(()-> {
                        throw new NotFoundException("Not found Material");
                    }
            );
            if(amountMa > s.getCurrentAmount()){
                System.out.println(amountMa +"--" + s.getCurrentAmount());
                throw new InvalidParameterException("Số lượng nguyên liệu không hợp lệ");
            }
            s.setCurrentAmount(s.getCurrentAmount()-amountMa);
            Material material = materialRepo.save(s);

            alertService.sendEmailAndNoti(user.getEmail() , material);

            ProductMaterial pm = ProductMaterial.builder()
                    .material(s)
                    .product(response)
                    .amountMaterial(amountMa)
                    .build();

            pmRepo.save(pm);

        });


        return modelMapper.map(response , ProductDto.class);
    }

    @Override
    @Transactional
    public ProductDto editProduct(ProductDto productDto, Long userId) throws JsonProcessingException {
        List list = objectMapper.readValue(productDto.getMaterialsJSON() , List.class);

        Product product = productRepository.findById(productDto.getId()).orElseThrow(() -> {
            throw new NotFoundException("Not fount product by id " + productDto.getId());
        });

        product.setName(productDto.getName());
        product.setAmount(productDto.getAmount());
        product.setStatus(productDto.getStatus());
//        if(productDto.getFile()!= null){
//            String fileName = fileStorageService.storeFile(productDto.getFile() , false);
//            product.setImage(fileName);
//        }

        User user = userRepo.getById(userId);
        product.setUser(user);

        List<Map<String , Object>> listMaterialDto = new ArrayList<>();

        list.forEach(item -> {
            listMaterialDto.add((Map<String, Object>) item);
        });



        Product response = productRepository.save(product);



        listMaterialDto.forEach(i -> {

            String nameMate = (String) i.get("name");
            Float amountMate = Float.parseFloat(String.valueOf(i.get("amountMaterial"))) ;

            Material m = materialRepo.findByName(nameMate).orElseThrow(()-> {
                        throw new NotFoundException("Not found material");
                    }
            );
            Optional<ProductMaterial> checkPm = pmRepo.findByProductAndMaterial(response , m);

            if(checkPm.isEmpty() && amountMate < m.getCurrentAmount()){
                m.setCurrentAmount(m.getCurrentAmount()-amountMate);
                materialRepo.save(m);

                ProductMaterial ms = ProductMaterial.builder()
                        .product(response)
                        .material(m)
                        .amountMaterial(amountMate)
                        .build();
                pmRepo.save(ms);

            } else if(checkPm.isPresent() && amountMate < m.getCurrentAmount() + checkPm.get().getAmountMaterial()){
                m.setCurrentAmount(m.getCurrentAmount()-(amountMate - checkPm.get().getAmountMaterial()));
                materialRepo.save(m);

                checkPm.get().setAmountMaterial(amountMate);
                pmRepo.save(checkPm.get());

                alertService.sendEmailAndNoti(user.getEmail() , m);
            } else {
                throw new InvalidParameterException("Số lượng nguyên liệu không hợp lệ");
            }

        });

        return modelMapper.map(response , ProductDto.class);
    }

    @Override
    public ProductDto removeProduct(Long id, Long userId) {
        Product product = productRepository.findById(id).orElseThrow(() -> {
                    throw new NotFoundException("Not found Product By Id");
                }
        );
        product.setStatus(0);
        return modelMapper.map(productRepository.save(product), ProductDto.class);
    }

    @Override
    public ProductDto pauseProduct(Long id, Long userId) {
        Product product = productRepository.findById(id).orElseThrow(() -> {
                    throw new NotFoundException("Not found Product By Id");
                }
        );
        if(product.getStatus() == 1){
            product.setStatus(2);
        }else {
            product.setStatus(1);
        }

        return modelMapper.map(productRepository.save(product), ProductDto.class);
    }

    private List<ProductDto> converseMaterialToDto(Page<Product> list){

        return list.stream().map(item -> {

            List<ProductMaterial> ms = pmRepo.findByProduct(item);

            List<Map<String,Object>> materials = new ArrayList<>();

            ms.forEach(s -> {
                Map<String, Object> map = new HashMap();

                map.put("id" , s.getMaterial().getId());
                map.put("name" , s.getMaterial().getName());
                map.put("amountMaterial" , s.getAmountMaterial());

                materials.add(map);
            });

            ProductDto dto = modelMapper.map(item, ProductDto.class);

            dto.setMaterials(materials);
            return dto;

        }).collect(Collectors.toList());

    }
}
