package com.thuctapcdit.qlnguyenlieube.api.v1;

import com.thuctapcdit.qlnguyenlieube.service.AlertService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/alert")
@CrossOrigin("*")
public class AlertController {
    private static final Logger logger = LogManager.getLogger(AuthenController.class);

    @Autowired
    private AlertService alertService;

    @GetMapping(value = "")
    public ResponseEntity<?> getAllAlert(@RequestParam("page") Integer page,
                                         @RequestParam("size") Integer size){
        logger.info("get all Alert");
        return ResponseEntity.ok().body(alertService.getAllAlert(page , size));
    }

    @PutMapping(value = "")
    public ResponseEntity<?> checkedAll(){
        logger.info("check all Alert");
        return ResponseEntity.ok().body(alertService.checkAll());
    }
}
