package com.thuctapcdit.qlnguyenlieube.service.impl;

import com.thuctapcdit.qlnguyenlieube.dao.WarningThresholdRepo;
import com.thuctapcdit.qlnguyenlieube.dto.WarningThresholdDto;
import com.thuctapcdit.qlnguyenlieube.model.WarningThreshold;
import com.thuctapcdit.qlnguyenlieube.service.WarningThresholdService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WarningThresholdServiceImpl implements WarningThresholdService {
    @Autowired
    private WarningThresholdRepo wtRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<WarningThresholdDto> getAllWH() {
        List<WarningThreshold> list = wtRepo.findAll();

        List<WarningThresholdDto> dtos = new ArrayList<>();
                list.forEach(item -> {
                    WarningThresholdDto dto = WarningThresholdDto.builder()
                            .id(item.getId())
                            .threshold(item.getThreshold())
                            .build();

                    dtos.add(dto);
                });

        return dtos;
    }
}
