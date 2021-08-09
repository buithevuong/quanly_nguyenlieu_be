package com.thuctapcdit.qlnguyenlieube.service.impl;

import com.thuctapcdit.qlnguyenlieube.dao.MaterialRepository;
import com.thuctapcdit.qlnguyenlieube.dao.MaterialSupplierRepo;
import com.thuctapcdit.qlnguyenlieube.dto.MaterialDto;
import com.thuctapcdit.qlnguyenlieube.model.Material;
import com.thuctapcdit.qlnguyenlieube.model.MaterialSupplier;
import com.thuctapcdit.qlnguyenlieube.service.MaterialService;
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
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialRepository materialRepo;

    @Autowired
    private MaterialSupplierRepo msRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<MaterialDto> getMaterials(Integer page, Integer size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Material> list = materialRepo.findAll(pageable);


        List<MaterialDto> data = list.stream().map(item -> {

            List<MaterialSupplier> ms = msRepo.findByMaterial(item);

            List<Object> suppliers = new ArrayList<>();

            ms.stream().forEach(s -> {
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

        return data;
    }

}
