package com.thuctapcdit.qlnguyenlieube.api.v1;

import com.thuctapcdit.qlnguyenlieube.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/alert")
@CrossOrigin(origins = "http://localhost:3000/")
public class AlertController {

    @Autowired
    private AlertService alertService;

    @GetMapping(value = "")
    public ResponseEntity<?> getAllAlert(@RequestParam("page") Integer page,
                                         @RequestParam("size") Integer size){

        return ResponseEntity.ok().body(alertService.getAllAlert(page , size));
    }
}
