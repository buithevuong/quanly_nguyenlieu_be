package com.thuctapcdit.qlnguyenlieube.api.v1;

import com.thuctapcdit.qlnguyenlieube.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/product")
@CrossOrigin(origins = "http://localhost:3000/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/search")
    public ResponseEntity<?> getProductsByName(@RequestParam("page") Integer page,
                                                @RequestParam("size") Integer size,
                                                @RequestParam("name") String name) {
        System.out.println(name);
        return ResponseEntity.ok().body(productService.getProductsByName(page, size, name));
    }
}
