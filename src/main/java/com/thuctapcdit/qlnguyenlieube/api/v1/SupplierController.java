package com.thuctapcdit.qlnguyenlieube.api.v1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.thuctapcdit.qlnguyenlieube.dto.SupplierDto;
import com.thuctapcdit.qlnguyenlieube.service.SupplierService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("v1/supplier")
@CrossOrigin("*")
public class SupplierController {

    private static final Logger logger = LogManager.getLogger(SupplierController.class);

    @Autowired
    private SupplierService supplierService;

    @GetMapping("")
    public ResponseEntity<?> getAllSupplier(){

        return ResponseEntity.ok().body(supplierService.getSupplier(1 , 1));
    }

    @GetMapping("/search")
    public ResponseEntity<?> getSuppliersByName(@RequestParam("page") @Min(1) Integer page,
                                                @RequestParam("size") @Min(1) @Max(10) Integer size,
                                                @RequestParam("name") String name,
                                                @RequestParam("phone") String phone,
                                                @RequestParam("email") String email,
                                                @RequestParam(value = "status" , required = false) Integer status) {

        return ResponseEntity.ok().body(supplierService.searchSupplier(page, size, name, phone , email , status));
    }

    @PostMapping( value = "")
    public ResponseEntity<?> addSupplier(@ModelAttribute @Valid SupplierDto supplierDto ,
                                         @RequestHeader Long userId) throws JsonProcessingException {

        logger.info("request add supplier {} by user {}", supplierDto.getName(), userId);

        return ResponseEntity.ok().body(supplierService.createSupplier(supplierDto , userId));
    }

    @PutMapping(value = "")
    public ResponseEntity<?> editSupplier(@ModelAttribute @Valid SupplierDto supplierDto,
                                          @RequestHeader Long userId) throws JsonProcessingException {

        logger.info("request edit supplier {} by user {}", supplierDto.getName(), userId);
        return ResponseEntity.ok().body(supplierService.editSupplier(supplierDto , userId));
    }

    @PutMapping("/remove")
    public ResponseEntity<?> removeSupplier(@RequestParam("id") Integer id,
                                            @RequestHeader Long userId) {

        logger.info("request remove supplier {} by user {}", id, userId);
        return ResponseEntity.ok().body(supplierService.removeSupplier(id.longValue() , userId));
    }
}
