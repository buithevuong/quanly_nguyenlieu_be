package com.thuctapcdit.qlnguyenlieube.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thuctapcdit.qlnguyenlieube.dao.*;
import com.thuctapcdit.qlnguyenlieube.dto.MaterialDto;
import com.thuctapcdit.qlnguyenlieube.dto.WarningThresholdDto;
import com.thuctapcdit.qlnguyenlieube.exception.NotFoundException;
import com.thuctapcdit.qlnguyenlieube.model.*;
import com.thuctapcdit.qlnguyenlieube.service.MaterialService;
import com.thuctapcdit.qlnguyenlieube.utils.FileStorageService;
import com.thuctapcdit.qlnguyenlieube.utils.MethodUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
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
    private WarningThresholdRepo wthRepo;

    @Autowired
    private MaterialWarningRepo mwRepo;

    @Autowired
    private WarningThresholdRepo wtRepo;

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
    public List<MaterialDto> getMaterialsByName(Integer page, Integer size, String name, String type, Integer status) {

        Pageable pageable = PageRequest.of(page, size);
        if (status == null) {
            Page<Material> list = materialRepo.findByNameLikeAndTypeLikeOrderByUpdatedAtDesc("%" + name + "%", "%" + type + "%", pageable);

            return converseSupplierToDto(list);
        }
        Page<Material> list = materialRepo.findByNameLikeAndTypeLikeAndStatusOrderByUpdatedAtDesc("%" + name + "%", "%" + type + "%", status, pageable);
        
        return converseSupplierToDto(list);
    }

    @Override
    @Transactional
    public MaterialDto createMaterial(MaterialDto materialDto) throws JsonProcessingException {


        List list = objectMapper.readValue(materialDto.getSuppliersJSON(), List.class);

        List listWths = objectMapper.readValue(materialDto.getWthsJSON(), List.class);
        //String fileName = fileStorageService.storeFile(materialDto.getFile() , false);

        Material material = modelMapper.map(materialDto, Material.class);
        material.setCurrentAmount(material.getTotal());
        material.setStatus(1);
        //material.setImage(fileName);
        material.setType(materialDto.getType());
        User user = userRepo.getById((long) 1);
        material.setUser(user);

        List<Map<String, Object>> listSupDto = new ArrayList<>();
        List<Map<String, Integer>> listWthDto = new ArrayList<>();
        list.forEach(item -> {
            listSupDto.add((Map<String, Object>) item);
        });


        listWths.forEach(item -> {
            listWthDto.add((Map<String, Integer>) item);
        });

        Material response = materialRepo.save(material);

        listSupDto.forEach(i -> {

            String nameSup = (String) i.get("name");
            Float amountMa = Float.parseFloat((String) i.get("amountMaterial"));


            Supplier s = supplierRepo.findByName(nameSup).orElseThrow(() -> {
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

        listWthDto.forEach(i -> {

            Float threshold = i.get("threshold").floatValue();


            WarningThreshold wt = wthRepo.findByThreshold(threshold).orElseThrow(() -> {
                        throw new NotFoundException("Not found warning threshold");
                    }
            );

            MaterialWarning mw = MaterialWarning.builder()
                    .material(response)
                    .warningThreshold(wt)
                    .build();

            mwRepo.save(mw);
        });
        System.out.println("done add material");
        return modelMapper.map(response, MaterialDto.class);

    }

    @Override
    @Transactional
    public MaterialDto editMaterial(MaterialDto materialDto) throws JsonProcessingException {
        List list = objectMapper.readValue(materialDto.getSuppliersJSON(), List.class);

        List listWths = objectMapper.readValue(materialDto.getWthsJSON(), List.class);

        Material material = materialRepo.findById(materialDto.getId()).orElseThrow(() -> {
            throw new NotFoundException("Not fount Material By Id :" + materialDto.getId());
        });
        Float amount = materialDto.getTotal() - material.getTotal();

        material.setName(materialDto.getName());
        material.setType(materialDto.getType());

        material.setTotal(materialDto.getTotal());
        material.setCurrentAmount(material.getCurrentAmount() + amount);

        User user = userRepo.getById((long) 1);
        material.setUser(user);

        List<Map<String, Object>> listSupDto = new ArrayList<>();
        List<Map<String, Integer>> listWthDto = new ArrayList<>();
        list.forEach(item -> {
            listSupDto.add((Map<String, Object>) item);
        });

        listWths.forEach(item -> {
            listWthDto.add((Map<String, Integer>) item);
        });


        Material response = materialRepo.save(material);


        List<Long> listAvailable = new ArrayList<>();


        //add or edit supplier
        listSupDto.forEach(i -> {

            String nameSup = (String) i.get("name");
            Float amountMa = Float.parseFloat(String.valueOf(i.get("amountMaterial")));


            Supplier s = supplierRepo.findByName(nameSup).orElseThrow(() -> {
                        throw new NotFoundException("Not found supplier");
                    }
            );

            Optional<MaterialSupplier> checkMs = msRepo.findByMaterialAndSupplier(response, s);

            if (checkMs.isEmpty()) {
                MaterialSupplier ms = MaterialSupplier.builder()
                        .supplier(s)
                        .material(response)
                        .amountMaterial(amountMa)
                        .build();

                listAvailable.add(msRepo.save(ms).getId());

            } else {
                checkMs.get().setAmountMaterial(amountMa);
                listAvailable.add(msRepo.save(checkMs.get()).getId());
            }

        });


        //delete ms else
        List<MaterialSupplier> listMs = msRepo.findByMaterial(response);

        listMs.forEach(i -> {
            listAvailable.forEach(j -> {
                if (!i.getId().equals(j) && !MethodUtils.checkIndexInArray(i.getId(), listAvailable)) {

                    msRepo.deleteById(i.getId());
                }
            });
        });

        //deleteAllMWByMaterial
        mwRepo.deleteByMaterial(response);

        //add warning for material
        listWthDto.forEach(i -> {

            Float threshold = i.get("threshold").floatValue();

            WarningThreshold wt = wthRepo.findByThreshold(threshold).orElseThrow(() -> {
                        throw new NotFoundException("Not found warning threshold");
                    }
            );

            Optional<MaterialWarning> checkMw = mwRepo.findByMaterialAndWarningThreshold(response, wt);

            if (checkMw.isEmpty()) {
                MaterialWarning mw = MaterialWarning.builder()
                        .material(response)
                        .warningThreshold(wt)
                        .build();

                mwRepo.save(mw);
            }
        });

        System.out.println("edit done material");
        return modelMapper.map(response, MaterialDto.class);
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


    private List<MaterialDto> converseSupplierToDto(Page<Material> list) {

        return list.stream().map(item -> {

            List<MaterialSupplier> ms = msRepo.findByMaterial(item);

            List<Map<String, Object>> suppliers = new ArrayList<>();

            ms.forEach(s -> {
                Map<String, Object> map = new HashMap();

                map.put("id", s.getSupplier().getId());
                map.put("name", s.getSupplier().getName());
                map.put("amountMaterial", s.getAmountMaterial());

                suppliers.add(map);
            });

            List<MaterialWarning> mw = mwRepo.findByMaterial(item);
            List<WarningThresholdDto> wtDtos = new ArrayList<>();

            mw.forEach(m -> {
                wtDtos.add(modelMapper.map(m.getWarningThreshold(), WarningThresholdDto.class));
            });

            MaterialDto dto = modelMapper.map(item, MaterialDto.class);

            dto.setWtDtos(wtDtos);
            dto.setSuppliers(suppliers);

            return dto;

        }).collect(Collectors.toList());

    }
}
