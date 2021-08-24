package com.thuctapcdit.qlnguyenlieube.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.thuctapcdit.qlnguyenlieube.dto.ProductDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> getProductsByName(Integer page , Integer size , String name , Integer status);

    ProductDto createProduct(ProductDto productDto , Long userId) throws JsonProcessingException;

    ProductDto editProduct(ProductDto productDto , Long userId) throws JsonProcessingException;

    ProductDto removeProduct(Long id, Long userId);

    ProductDto pauseProduct(Long id, Long userId);
}
