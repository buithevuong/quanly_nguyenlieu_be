package com.thuctapcdit.qlnguyenlieube.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thuctapcdit.qlnguyenlieube.dao.MaterialRepository;

@RestController
@RequestMapping("v1/material")
@CrossOrigin(origins = "http://localhost:3000")
public class MaterialController {

	@Autowired
	private MaterialRepository materialRepository;
	
	@GetMapping("")
	public ResponseEntity<?> getAllMaterial(){
		return ResponseEntity.ok().body(materialRepository.findAll());
	}

	
}
