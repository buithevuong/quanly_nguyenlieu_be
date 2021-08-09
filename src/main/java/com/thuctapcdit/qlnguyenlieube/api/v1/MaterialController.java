package com.thuctapcdit.qlnguyenlieube.api.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thuctapcdit.qlnguyenlieube.service.MaterialService;

@RestController
@RequestMapping("v1/material")
public class MaterialController {

	@Autowired
	private MaterialService materialService;
	
	@GetMapping("")
	public ResponseEntity<?> getMaterials(@RequestParam("page") Integer page , @RequestParam("size") Integer size){
		
		return ResponseEntity.ok().body(materialService.getMaterials(page, size));
	}
	
	
}
