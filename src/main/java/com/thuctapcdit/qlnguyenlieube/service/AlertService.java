package com.thuctapcdit.qlnguyenlieube.service;

import com.thuctapcdit.qlnguyenlieube.model.Material;

import java.util.Map;


public interface AlertService {

    Map<String , Object> getAllAlert(Integer page , Integer size);

    void sendEmailAndNoti(String email , Material material);

    boolean checkAll();
}
