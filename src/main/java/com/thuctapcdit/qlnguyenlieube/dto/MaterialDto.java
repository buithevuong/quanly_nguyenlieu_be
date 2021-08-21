package com.thuctapcdit.qlnguyenlieube.dto;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.thuctapcdit.qlnguyenlieube.model.WarningThreshold;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MaterialDto {

	private Long id;

	@NotBlank
	private String name;

	private String type;

	private String image;

	private MultipartFile file;

	private InputStreamResource fileResponse;

	private Float currentAmount;

	private Float total;

	private Integer status;

	private Date createdAt;

	private Date updatedAt;
	
	private List<Map<String,Object>> suppliers;

	private List<WarningThresholdDto> wtDtos;

	private String wthsJSON;

	private String suppliersJSON;

	private Float threshold;
}
