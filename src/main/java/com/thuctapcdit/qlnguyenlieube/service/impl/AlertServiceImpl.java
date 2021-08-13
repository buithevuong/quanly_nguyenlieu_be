package com.thuctapcdit.qlnguyenlieube.service.impl;

import com.thuctapcdit.qlnguyenlieube.dao.AlertRepository;
import com.thuctapcdit.qlnguyenlieube.dto.AlertDto;
import com.thuctapcdit.qlnguyenlieube.model.Alert;
import com.thuctapcdit.qlnguyenlieube.service.AlertService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AlertServiceImpl implements AlertService {

    @Autowired
    private AlertRepository alertRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JavaMailSender emailSender;


    @Override
    public Map<String , Object> getAllAlert(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page , size);

        Page<Alert> list =  alertRepository.findAll(pageable);

        List<AlertDto> dtos =  list.stream().map(a -> {
            AlertDto dto = modelMapper.map(a , AlertDto.class);
            dto.setMaterialName(a.getMaterial().getName());
            return dto;
        }).collect(Collectors.toList());

        Map<String , Object> map = new HashMap<>();
        map.put("alerts" , dtos);

        Long countNotCheck = alertRepository.countByIsChecked(1);
        map.put("totalNotCheck" , countNotCheck);
        return map;
    }

    private void sendEmailNoti(String email , AlertDto alertDto){
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

            simpleMailMessage.setTo(email);
            simpleMailMessage.setSubject(alertDto.getTitle());
            simpleMailMessage.setText(alertDto.getContent());

            emailSender.send(simpleMailMessage);
        } catch (Exception ex) {
            throw new InvalidParameterException(ex.getMessage());
        }

    }
}
