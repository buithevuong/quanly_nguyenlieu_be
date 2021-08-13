package com.thuctapcdit.qlnguyenlieube.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.thuctapcdit.qlnguyenlieube.dao.SupplierRepository;
import com.thuctapcdit.qlnguyenlieube.dto.SupplierDto;
import com.thuctapcdit.qlnguyenlieube.model.Material;
import com.thuctapcdit.qlnguyenlieube.model.Supplier;
import com.thuctapcdit.qlnguyenlieube.service.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<SupplierDto> getSupplier(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Supplier> list = supplierRepo.findAll(pageable);

        return list.stream().map(item -> {
            SupplierDto dto = modelMapper.map(item , SupplierDto.class);
            return dto;
        }).collect(Collectors.toList());

    }

    @Override
    public List<SupplierDto> searchSupplier(Integer page, Integer size, String name , String phone, String email) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Supplier> list = supplierRepo
                .findByNameLikeAndPhoneLikeAndEmailLike("%"+name+"%" , "%"+phone+"%" , "%"+email+"%" ,pageable);

        return list.stream().map(item -> {
            SupplierDto dto = modelMapper.map(item , SupplierDto.class);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public SupplierDto createSupplier(SupplierDto supplierDto) throws JsonProcessingException {
        return null;
    }

    @Override
    public SupplierDto editSupplier(SupplierDto supplierDto) throws JsonProcessingException {
        return null;
    }

    @Override
    public SupplierDto removeSupplier(Long id) {
        return null;
    }
}
