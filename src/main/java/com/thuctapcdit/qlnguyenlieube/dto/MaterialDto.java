package com.thuctapcdit.qlnguyenlieube.dto;

import java.util.Date;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MaterialDto {

	private Long id;

	private String name;

	private String image;

	private Float currentAmount;

	private Float total;

	private Integer status;

	private Date createdAt;

	private Date updatedAt;
	
	private List<Object> suppliers;
}
