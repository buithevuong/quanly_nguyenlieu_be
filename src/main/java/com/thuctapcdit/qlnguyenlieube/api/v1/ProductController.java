package com.thuctapcdit.qlnguyenlieube.api.v1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.thuctapcdit.qlnguyenlieube.dto.ProductDto;
import com.thuctapcdit.qlnguyenlieube.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("v1/product")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/search")
    public ResponseEntity<?> getProductsByName(@RequestParam("page") @Min(0) Integer page,
                                                @RequestParam("size") @Min(1) @Max(10) Integer size,
                                                @RequestParam("name") String name,
                                               @RequestParam(value = "status" , required = false) Integer status) {
        return ResponseEntity.ok().body(productService.getProductsByName(page, size, name , status));
    }

    @PostMapping( value = "")
    public ResponseEntity<?> addProduct(@ModelAttribute @Valid ProductDto productDto ) throws JsonProcessingException {
        return ResponseEntity.ok().body(productService.createProduct(productDto));
    }

    @PutMapping(value = "")
    public ResponseEntity<?> editProduct(@ModelAttribute @Valid ProductDto productDto) throws JsonProcessingException {
        return ResponseEntity.ok().body(productService.editProduct(productDto));
    }

    @PutMapping("/remove")
    public ResponseEntity<?> removeProduct(@RequestParam("id") Long id) {
        return ResponseEntity.ok().body(productService.removeProduct(id));
    }

    @PutMapping("/pause")
    public ResponseEntity<?> pauseProduct(@RequestParam("id") Long id) {
        return ResponseEntity.ok().body(productService.pauseProduct(id));
    }
}
