package com.thuctapcdit.qlnguyenlieube.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "productmaterial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
public class ProductMaterial {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(optional=false)
    @JoinColumn(name="MaterialId", nullable=false)
	private Material material;
	
	@ManyToOne(optional=false)
    @JoinColumn(name="ProductId", nullable=false)
	private Product product;
	
	@Column(name = "amountMaterial")
	private Float amountMaterial;

	
	@Column(name = "CreatedAt")
	private Date createdAt;
}
