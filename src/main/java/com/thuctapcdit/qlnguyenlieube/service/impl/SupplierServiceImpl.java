package com.thuctapcdit.qlnguyenlieube.service.impl;

import com.thuctapcdit.qlnguyenlieube.dao.SupplierRepository;
import com.thuctapcdit.qlnguyenlieube.dao.UserRepo;
import com.thuctapcdit.qlnguyenlieube.dto.SupplierDto;
import com.thuctapcdit.qlnguyenlieube.exception.NotFoundException;
import com.thuctapcdit.qlnguyenlieube.model.Supplier;
import com.thuctapcdit.qlnguyenlieube.model.User;
import com.thuctapcdit.qlnguyenlieube.service.SupplierService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<SupplierDto> getSupplier(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Supplier> list = supplierRepo.findAll(pageable);

        return list.stream().map(item -> {
            SupplierDto dto = modelMapper.map(item, SupplierDto.class);
            return dto;
        }).collect(Collectors.toList());

    }

    @Override
    public List<SupplierDto> searchSupplier(Integer page,
                                            Integer size,
                                            String name,
                                            String phone,
                                            String email,
                                            Integer status) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Supplier> list;
        if (status == null) {
            list = supplierRepo
                    .findByNameLikeAndPhoneLikeAndEmailLikeOrderByUpdatedAtDesc(
                            "%" + name + "%",
                            "%" + phone + "%",
                            "%" + email + "%",
                            pageable);

        } else {
            list = supplierRepo
                    .findByNameLikeAndPhoneLikeAndEmailLikeAndStatusOrderByUpdatedAtDesc(
                            "%" + name + "%",
                            "%" + phone + "%",
                            "%" + email + "%",
                            status,
                            pageable);

        }
        return list.stream().map(item -> {
            SupplierDto dto = modelMapper.map(item, SupplierDto.class);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public SupplierDto createSupplier(SupplierDto supplierDto) {
        Supplier supplier = modelMapper.map(supplierDto, Supplier.class);
        supplier.setStatus(1);
        User user = userRepo.findById(1L).get();
        supplier.setUser(user);
        return modelMapper.map(supplierRepo.save(supplier), SupplierDto.class);
    }

    @Override
    @Transactional
    public SupplierDto editSupplier(SupplierDto supplierDto) {
        Supplier supplier = supplierRepo.findById(supplierDto.getId()).orElseThrow(() -> {
            throw new NotFoundException("Not found Supplier");
        });

        supplier.setName(supplierDto.getName());
        supplier.setAddress(supplierDto.getAddress());
        supplier.setEmail(supplierDto.getEmail());
        supplier.setUser(userRepo.findById(1L).get());
        supplier.setStatus(supplierDto.getStatus());
        supplier.setPhone(supplierDto.getPhone());

        return modelMapper.map(supplierRepo.save(supplier), SupplierDto.class);
    }

    @Override
    public SupplierDto removeSupplier(Long id) {
        Supplier supplier = supplierRepo.findById(id).orElseThrow(() -> {
                    throw new NotFoundException("Not found Supplier By Id");
                }
        );
        supplier.setStatus(0);
        return modelMapper.map(supplierRepo.save(supplier), SupplierDto.class);
    }
}
