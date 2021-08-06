package com.thuctapcdit.qlnguyenlieube.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
public class Product {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Image")
	private String image;

	@Column(name = "Amount")
	private Float amount;

	@Column(name = "Status")
	private Integer status;

	@Column(name = "CreatedAt")
	private Date createdAt;

	@Column(name = "UpdatedAt")
	private Date updatedAt;
	
	@OneToMany(mappedBy="product", fetch = FetchType.LAZY)
    private Set<ProductMaterial> productMaterials;
}
