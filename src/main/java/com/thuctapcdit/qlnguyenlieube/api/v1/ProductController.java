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
@CrossOrigin(origins = "http://localhost:3000/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/search")
    public ResponseEntity<?> getProductsByName(@RequestParam("page") @Min(0) Integer page,
                                                @RequestParam("size") @Min(1) @Max(10) Integer size,
                                                @RequestParam("name") String name) {
        System.out.println(name);
        return ResponseEntity.ok().body(productService.getProductsByName(page, size, name));
    }

    @PostMapping( value = "")
    public ResponseEntity<?> addProduct(@ModelAttribute @Valid ProductDto productDto ) throws JsonProcessingException {

        System.out.println(productDto);
        return ResponseEntity.ok().body(productService.createProduct(productDto));
    }

    @PutMapping(value = "")
    public ResponseEntity<?> editProduct(@ModelAttribute @Valid ProductDto productDto) throws JsonProcessingException {

        System.out.println(productDto);
        return ResponseEntity.ok().body(productService.editProduct(productDto));
    }

    @PutMapping("/remove")
    public ResponseEntity<?> removeProduct(@RequestParam("id") Integer id) {
        return ResponseEntity.ok().body(productService.removeProduct(id.longValue()));
    }
}
