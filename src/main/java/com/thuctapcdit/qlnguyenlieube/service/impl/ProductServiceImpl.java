package com.thuctapcdit.qlnguyenlieube.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.thuctapcdit.qlnguyenlieube.dao.ProductMaterialRepo;
import com.thuctapcdit.qlnguyenlieube.dao.ProductRepository;
import com.thuctapcdit.qlnguyenlieube.dto.MaterialDto;
import com.thuctapcdit.qlnguyenlieube.dto.ProductDto;
import com.thuctapcdit.qlnguyenlieube.dto.SupplierDto;
import com.thuctapcdit.qlnguyenlieube.model.*;
import com.thuctapcdit.qlnguyenlieube.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMaterialRepo pmRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductDto> getProductsByName(Integer page, Integer size, String name) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> list = productRepository
                .findByNameLike("%"+name+"%" , pageable);

        return converseMaterialToDto(list);
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) throws JsonProcessingException {
        return null;
    }

    @Override
    public ProductDto editProduct(ProductDto productDto) throws JsonProcessingException {
        return null;
    }

    @Override
    public ProductDto removeProduct(Long id) {
        return null;
    }

    private List<ProductDto> converseMaterialToDto(Page<Product> list){

        return list.stream().map(item -> {

            List<ProductMaterial> ms = pmRepo.findByProduct(item);

            List<Map<String,Object>> materials = new ArrayList<>();

            ms.forEach(s -> {
                Map<String, Object> map = new HashMap();

                map.put("id" , s.getMaterial().getId());
                map.put("name" , s.getMaterial().getName());
                map.put("amountMaterial" , s.getAmountMaterial());

                materials.add(map);
            });

            ProductDto dto = modelMapper.map(item, ProductDto.class);

            dto.setMaterials(materials);
            return dto;

        }).collect(Collectors.toList());

    }
}
