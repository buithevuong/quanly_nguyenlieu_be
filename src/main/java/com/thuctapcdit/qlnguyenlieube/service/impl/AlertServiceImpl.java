package com.thuctapcdit.qlnguyenlieube.service.impl;

import com.thuctapcdit.qlnguyenlieube.dao.AlertRepository;
import com.thuctapcdit.qlnguyenlieube.dao.MaterialWarningRepo;
import com.thuctapcdit.qlnguyenlieube.dto.AlertDto;
import com.thuctapcdit.qlnguyenlieube.model.Alert;
import com.thuctapcdit.qlnguyenlieube.model.Material;
import com.thuctapcdit.qlnguyenlieube.model.MaterialWarning;
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

    @Autowired
    private MaterialWarningRepo mwRepo;

    @Override
    public Map<String , Object> getAllAlert(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page , size);

        Page<Alert> list =  alertRepository.findAllByOrderByCreatedAtDesc(pageable);

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
    @Override
    public void sendEmailAndNoti(String email , Material material){
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            List<MaterialWarning> listMw = mwRepo.findByMaterial(material);

            float tile = (material.getCurrentAmount()/material.getTotal())*100;
            listMw.forEach(i -> {
                if(tile < i.getWarningThreshold().getThreshold() ){

                    Alert alert = Alert.builder()
                            .material(material)
                            .title("Cảnh báo mức lượng nguyên liệu còn lại")
                            .content("Lượng nguyên liệu còn lại là "+tile + "%")
                            .color("red")
                            .isChecked(1)
                            .build();

                    alertRepository.save(alert);

                    simpleMailMessage.setTo(email);
                    simpleMailMessage.setSubject(alert.getTitle());
                    simpleMailMessage.setText(alert.getContent());

                    emailSender.send(simpleMailMessage);

                    System.out.println("Email sended to "+ email + " : "+alert.getContent());
                }
            });


        } catch (Exception ex) {
            throw new InvalidParameterException(ex.getMessage());
        }

    }
}
