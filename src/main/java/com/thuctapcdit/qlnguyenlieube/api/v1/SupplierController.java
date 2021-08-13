package com.thuctapcdit.qlnguyenlieube.api.v1;

import com.thuctapcdit.qlnguyenlieube.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> getMaterialsByName(@RequestParam("page") Integer page,
                                                @RequestParam("size") Integer size,
                                                @RequestParam("name") String name,
                                                @RequestParam("phone") String phone,
                                                @RequestParam("email") String email) {



        return ResponseEntity.ok().body(supplierService.searchSupplier(page, size, name, phone , email));
    }
}
