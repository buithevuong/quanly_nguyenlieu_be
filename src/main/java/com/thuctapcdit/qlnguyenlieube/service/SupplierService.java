package com.thuctapcdit.qlnguyenlieube.service;

import com.thuctapcdit.qlnguyenlieube.dto.SupplierDto;

import java.util.List;

public interface SupplierService {

    List<SupplierDto> getSupplier(Integer page , Integer size);
}
