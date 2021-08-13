package com.thuctapcdit.qlnguyenlieube.api.v1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.thuctapcdit.qlnguyenlieube.dto.SupplierDto;
import com.thuctapcdit.qlnguyenlieube.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("v1/supplier")
@CrossOrigin(origins = "*")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("")
    public ResponseEntity<?> getAllSupplier(@RequestParam("page") Integer page,
                                            @RequestParam("size") Integer size){

        return ResponseEntity.ok().body(supplierService.getSupplier(page , size));
    }

    @GetMapping("/search")
    public ResponseEntity<?> getSuppliersByName(@RequestParam("page") @Min(1) Integer page,
                                                @RequestParam("size") @Min(1) @Max(10) Integer size,
                                                @RequestParam("name") String name,
                                                @RequestParam("phone") String phone,
                                                @RequestParam("email") String email) {



        return ResponseEntity.ok().body(supplierService.searchSupplier(page, size, name, phone , email));
    }

    @PostMapping( value = "")
    public ResponseEntity<?> addSupplier(@ModelAttribute @Valid SupplierDto supplierDto ) throws JsonProcessingException {

        System.out.println(supplierDto);
        return ResponseEntity.ok().body(supplierService.createSupplier(supplierDto));
    }

    @PutMapping(value = "")
    public ResponseEntity<?> editSupplier(@ModelAttribute @Valid SupplierDto supplierDto) throws JsonProcessingException {

        System.out.println(supplierDto);
        return ResponseEntity.ok().body(supplierService.editSupplier(supplierDto));
    }

    @PutMapping("/remove")
    public ResponseEntity<?> removeSupplier(@RequestParam("id") Integer id) {
        return ResponseEntity.ok().body(supplierService.removeSupplier(id.longValue()));
    }
}
