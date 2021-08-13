package com.thuctapcdit.qlnguyenlieube.dto;

import java.util.Date;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
	

	private Long id;

	@NotBlank
	private String name;


	private String image;

	private MultipartFile file;
	
	private Float amount;

	
	private Integer status;

	private Date createdAt;


	private Date updatedAt;

	private List<Map<String,Object>> materials;

	private String materialsJSON;
}
