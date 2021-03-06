package com.thuctapcdit.qlnguyenlieube.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.thuctapcdit.qlnguyenlieube.dto.MaterialDto;
import com.thuctapcdit.qlnguyenlieube.model.Material;
import org.springframework.web.multipart.MultipartFile;

public interface MaterialService {
	
	List<MaterialDto> getMaterials(Integer page , Integer size);

	List<MaterialDto> getMaterialsByName(Integer page , Integer size , String name , String type ,Integer status);

	MaterialDto createMaterial(MaterialDto materialDto , Long userId) throws JsonProcessingException;

	MaterialDto editMaterial(MaterialDto materialDto , Long userId) throws JsonProcessingException;

	MaterialDto removeMaterial(Long id, Long userId);
}
