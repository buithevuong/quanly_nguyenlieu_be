package com.thuctapcdit.qlnguyenlieube.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
	

	private Long id;

	
	private String name;


	private String image;

	
	private Float amount;

	
	private Integer status;

	private Date createdAt;


	private Date updatedAt;
	
}
