package com.thuctapcdit.qlnguyenlieube.api.v1;

import com.thuctapcdit.qlnguyenlieube.service.WarningThresholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/wth")
@CrossOrigin("*")
public class WThController {

    @Autowired
    private WarningThresholdService wtService;

    @GetMapping("")
    public ResponseEntity<?> getAllWth(){
        return ResponseEntity.ok().body(wtService.getAllWH());
    }
}
