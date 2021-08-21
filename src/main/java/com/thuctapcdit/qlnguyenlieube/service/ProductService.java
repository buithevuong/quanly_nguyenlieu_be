package com.thuctapcdit.qlnguyenlieube.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.thuctapcdit.qlnguyenlieube.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getProductsByName(Integer page , Integer size , String name , Integer status);

    ProductDto createProduct(ProductDto productDto ) throws JsonProcessingException;

    ProductDto editProduct(ProductDto productDto ) throws JsonProcessingException;

    ProductDto removeProduct(Long id);

    ProductDto pauseProduct(Long id);
}
