package com.thuctapcdit.qlnguyenlieube.api.v1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.thuctapcdit.qlnguyenlieube.dao.SupplierRepository;
import com.thuctapcdit.qlnguyenlieube.dto.MaterialDto;
import com.thuctapcdit.qlnguyenlieube.service.MaterialService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("v1/material")
@CrossOrigin(origins = "*")
public class MaterialController {

    private static final Logger logger = LogManager.getLogger(MaterialController.class);

    @Autowired
    private MaterialService materialService;

    @Autowired
    private SupplierRepository sr;

    @GetMapping("")
    public ResponseEntity<?> getMaterials(@RequestParam("page") Integer page,
                                          @RequestParam("size") Integer size) {

        return ResponseEntity.ok().body(materialService.getMaterials(page, size));
    }

    @GetMapping("/search")
    public ResponseEntity<?> getMaterialsByName(@RequestParam("page") Integer page,
                                                @RequestParam("size") Integer size,
                                                @RequestParam("name") String name,
                                                @RequestParam("type") String type) {

        logger.info("request search by name: {}", name);

        return ResponseEntity.ok().body(materialService.getMaterialsByName(page, size, name, type));
    }

    @PostMapping( value = "")
    public ResponseEntity<?> addMaterial(@ModelAttribute MaterialDto materialDto ) throws JsonProcessingException {

        System.out.println(materialDto);
        return ResponseEntity.ok().body(materialService.createMaterial(materialDto));
    }

    @PutMapping("/remove")
    public ResponseEntity<?> removeMaterial(@RequestParam("id") Integer id) {
        return ResponseEntity.ok().body(materialService.removeMaterial(id.longValue()));
    }
}
