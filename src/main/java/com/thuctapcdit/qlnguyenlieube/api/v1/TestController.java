package com.thuctapcdit.qlnguyenlieube.api.v1;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thuctapcdit.qlnguyenlieube.dao.ProductRepository;
import com.thuctapcdit.qlnguyenlieube.dto.ProductDto;

@RestController
@RequestMapping("/v1/test")
public class TestController {

	@Autowired
	private ProductRepository proRepo;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/product")
	public ResponseEntity<?> getAllProduct(){
		List<ProductDto> list = proRepo.findAll().stream()
		.map(item -> modelMapper.map(item, ProductDto.class)).collect(Collectors.toList());
		return ResponseEntity.ok(list);
	}
}
