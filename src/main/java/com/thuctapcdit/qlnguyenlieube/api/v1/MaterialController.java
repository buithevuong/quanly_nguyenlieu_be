package com.thuctapcdit.qlnguyenlieube.api.v1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.thuctapcdit.qlnguyenlieube.dto.MaterialDto;
import com.thuctapcdit.qlnguyenlieube.service.MaterialService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("v1/material")
@CrossOrigin("*")
public class MaterialController {

    private static final Logger logger = LogManager.getLogger(MaterialController.class);

    @Autowired
    private MaterialService materialService;

    @GetMapping("")
    public ResponseEntity<?> getMaterials(@RequestParam("page") @Min(0) Integer page,
                                          @RequestParam("size") @Min(1) @Max(50) Integer size) {

        return ResponseEntity.ok().body(materialService.getMaterials(page, size));
    }

    @GetMapping("/search")
    public ResponseEntity<?> getMaterialsByName(@RequestParam("page") @Min(0) Integer page,
                                                @RequestParam("size") @Min(1) @Max(50) Integer size,
                                                @RequestParam("name") String name,
                                                @RequestParam("type") String type,
                                                @RequestParam(value = "status" , required = false) Integer status) {

        return ResponseEntity.ok()
                .body(materialService.getMaterialsByName(page, size, name, type , status));
    }

    @PostMapping(value = "")
    public ResponseEntity<?> addMaterial(@ModelAttribute @Valid MaterialDto materialDto ,
                                         @RequestHeader Long userId) throws JsonProcessingException {
        System.out.println(materialDto);
        logger.info("add material {} by user id = {} ", materialDto.getName() , userId);
        return ResponseEntity.ok().body(materialService.createMaterial(materialDto , userId));
    }

    @PutMapping(value = "")
    public ResponseEntity<?> editMaterial(@ModelAttribute @Valid MaterialDto materialDto,
                                          @RequestHeader Long userId) throws JsonProcessingException {

        logger.info("edit material {} by {} ", materialDto.getId() , userId);
        return ResponseEntity.ok().body(materialService.editMaterial(materialDto , userId));
    }

    @PutMapping("/remove")
    public ResponseEntity<?> removeMaterial(@RequestParam("id") Integer id,
                                            @RequestHeader Long userId) {
        logger.info("remove material {} by userId = {} ", id , userId);
        return ResponseEntity.ok().body(materialService.removeMaterial(id.longValue(),userId));
    }
}
