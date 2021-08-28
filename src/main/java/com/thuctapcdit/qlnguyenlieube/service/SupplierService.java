package com.thuctapcdit.qlnguyenlieube.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.thuctapcdit.qlnguyenlieube.dto.SupplierDto;

import java.util.List;

public interface SupplierService {

    List<String> getSupplier(Integer page , Integer size);

    List<SupplierDto> searchSupplier(Integer page , Integer size , String name , String phone, String email, Integer status);

    SupplierDto createSupplier(SupplierDto supplierDto ,Long userId) throws JsonProcessingException;

    SupplierDto editSupplier(SupplierDto supplierDto ,Long userId) throws JsonProcessingException;

    SupplierDto removeSupplier(Long id,Long userId);
}
