package com.thuctapcdit.qlnguyenlieube.service;

import java.util.List;

import com.thuctapcdit.qlnguyenlieube.dto.MaterialDto;

public interface MaterialService {
	
	List<MaterialDto> getMaterials(Integer page , Integer size);
}
