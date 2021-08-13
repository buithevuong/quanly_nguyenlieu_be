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
import com.thuctapcdit.qlnguyenlieube.service.ProductService;
import com.thuctapcdit.qlnguyenlieube.utils.FileStorageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @Autowired
    private FileStorageService fileStorageService;

    @Override
    public List<ProductDto> getProductsByName(Integer page, Integer size, String name) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> list = productRepository
                .findByNameLike("%"+name+"%" , pageable);

        return converseMaterialToDto(list);
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) throws JsonProcessingException {
        List list = objectMapper.readValue(productDto.getMaterialsJSON() , List.class);

        String fileName = fileStorageService.storeFile(productDto.getFile() , false);

        Product product = modelMapper.map(productDto , Product.class);
        product.setStatus(1);
        product.setImage(fileName);
        User user = userRepo.getById((long) 1);
        product.setUser(user);

        List<Map<String , Object>> listMaterialDto = new ArrayList<>();

        list.forEach(item -> {
            listMaterialDto.add((Map<String, Object>) item);
        });



        Product response = productRepository.save(product);

        if(response != null){
            listMaterialDto.forEach(i -> {

                String nameMat = (String) i.get("name");
                Float amountMa = Float.parseFloat((String) i.get("amountMaterial")) ;


                Material s = materialRepo.findByName(nameMat).orElseThrow(()-> {
                            throw new NotFoundException("Not found Material");
                        }
                );

                ProductMaterial pm = ProductMaterial.builder()
                        .material(s)
                        .product(response)
                        .amountMaterial(amountMa)
                        .build();

                pmRepo.save(pm);

            });
        }

        return modelMapper.map(response , ProductDto.class);
    }

    @Override
    public ProductDto editProduct(ProductDto productDto) throws JsonProcessingException {
        return null;
    }

    @Override
    public ProductDto removeProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> {
                    throw new NotFoundException("Not found Product By Id");
                }
        );
        product.setStatus(0);
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
