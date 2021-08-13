package com.thuctapcdit.qlnguyenlieube.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thuctapcdit.qlnguyenlieube.dao.MaterialRepository;
import com.thuctapcdit.qlnguyenlieube.dao.MaterialSupplierRepo;
import com.thuctapcdit.qlnguyenlieube.dao.SupplierRepository;
import com.thuctapcdit.qlnguyenlieube.dao.UserRepo;
import com.thuctapcdit.qlnguyenlieube.dto.MaterialDto;
import com.thuctapcdit.qlnguyenlieube.exception.NotFoundException;
import com.thuctapcdit.qlnguyenlieube.model.Material;
import com.thuctapcdit.qlnguyenlieube.model.MaterialSupplier;
import com.thuctapcdit.qlnguyenlieube.model.Supplier;
import com.thuctapcdit.qlnguyenlieube.model.User;
import com.thuctapcdit.qlnguyenlieube.service.MaterialService;
import com.thuctapcdit.qlnguyenlieube.utils.FileStorageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialRepository materialRepo;

    @Autowired
    private MaterialSupplierRepo msRepo;

    @Autowired
    private SupplierRepository supplierRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private FileStorageService fileStorageService;

    @Override
    public List<MaterialDto> getMaterials(Integer page, Integer size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Material> list = materialRepo.findAll(pageable);

        return converseSupplierToDto(list);
    }

    @Override
    public List<MaterialDto> getMaterialsByName(Integer page, Integer size, String name , String type) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Material> list = materialRepo.findByNameLikeAndTypeLikeOrderByUpdatedAtDesc("%"+name+"%","%"+type+"%" ,pageable);

        return converseSupplierToDto(list);
    }

    @Override
    public MaterialDto createMaterial(MaterialDto materialDto ) throws JsonProcessingException {


            List list = objectMapper.readValue(materialDto.getSuppliersJSON() , List.class);

            String fileName = fileStorageService.storeFile(materialDto.getFile() , false);

            Material material = modelMapper.map(materialDto , Material.class);
            material.setCurrentAmount(material.getTotal());
            material.setStatus(1);
            material.setImage(fileName);
            material.setType(materialDto.getType());
            User user = userRepo.getById((long) 1);
            material.setUser(user);

            List<Map<String , Object>> listSupDto = new ArrayList<>();

        list.forEach(item -> {
            listSupDto.add((Map<String, Object>) item);
        });



            Material response = materialRepo.save(material);

            if(response != null){
                listSupDto.forEach(i -> {

                    String nameSup = (String) i.get("name");
                    Float amountMa = Float.parseFloat((String) i.get("amountMaterial")) ;


                    Supplier s = supplierRepo.findByName(nameSup).orElseThrow(()-> {
                                throw new NotFoundException("Not found supplier");
                            }
                    );

                    MaterialSupplier ms = MaterialSupplier.builder()
                            .supplier(s)
                            .material(response)
                            .amountMaterial(amountMa)
                            .build();
                    msRepo.save(ms);

                });
            }

            return modelMapper.map(response , MaterialDto.class);

    }

    @Override
    public MaterialDto editMaterial(MaterialDto materialDto) throws JsonProcessingException {
        List list = objectMapper.readValue(materialDto.getSuppliersJSON() , List.class);

        Material material = materialRepo.findById(materialDto.getId()).orElseThrow(()-> {
            throw new NotFoundException("Not fount Material By Id :" + materialDto.getId());
        });

        material.setName(materialDto.getName());
        material.setType(materialDto.getType());
        material.setTotal(materialDto.getTotal());
        material.setCurrentAmount(material.getTotal() - materialDto.getTotal() + material.getCurrentAmount());

        if(materialDto.getFile()!= null){
            String fileName = fileStorageService.storeFile(materialDto.getFile() , false);
            material.setImage(fileName);
        }

        User user = userRepo.getById((long) 1);
        material.setUser(user);

        List<Map<String , Object>> listSupDto = new ArrayList<>();

        list.forEach(item -> {
            listSupDto.add((Map<String, Object>) item);
        });



        Material response = materialRepo.save(material);

        if(response != null){
            listSupDto.forEach(i -> {

                String nameSup = (String) i.get("name");
                Float amountMa = Float.parseFloat(String.valueOf(i.get("amountMaterial"))) ;



                Supplier s = supplierRepo.findByName(nameSup).orElseThrow(()-> {
                            throw new NotFoundException("Not found supplier");
                        }
                );

                MaterialSupplier checkMs = msRepo.findByMaterialAndSupplier(response , s);

                if(checkMs == null){
                    MaterialSupplier ms = MaterialSupplier.builder()
                            .supplier(s)
                            .material(response)
                            .amountMaterial(amountMa)
                            .build();
                    msRepo.save(ms);
                } else {
                    checkMs.setAmountMaterial(amountMa);
                    msRepo.save(checkMs);
                }

            });
        }

        return modelMapper.map(response , MaterialDto.class);
    }

    @Override
    public MaterialDto removeMaterial(Long id) {
        Material material = materialRepo.findById(id).orElseThrow(() -> {
                    throw new NotFoundException("Not found Material By Id");
                }
        );

    material.setStatus(0);
        return modelMapper.map(materialRepo.save(material), MaterialDto.class);
    }


    private List<MaterialDto> converseSupplierToDto(Page<Material> list){

        return list.stream().map(item -> {

            List<MaterialSupplier> ms = msRepo.findByMaterial(item);

            List<Map<String,Object>> suppliers = new ArrayList<>();

            ms.forEach(s -> {
                Map<String, Object> map = new HashMap();

                map.put("id" , s.getSupplier().getId());
                map.put("name" , s.getSupplier().getName());
                map.put("amountMaterial" , s.getAmountMaterial());

                suppliers.add(map);
            });

            MaterialDto dto = modelMapper.map(item, MaterialDto.class);

            dto.setSuppliers(suppliers);
            return dto;

        }).collect(Collectors.toList());

    }
}
