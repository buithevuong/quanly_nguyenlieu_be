package com.thuctapcdit.qlnguyenlieube.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "material_supplier")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
public class MaterialSupplier {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(optional=false , fetch = FetchType.LAZY)
    @JoinColumn(name="material_id", nullable=false)
	private Material material;
	
	@ManyToOne(optional=false, fetch = FetchType.LAZY)
    @JoinColumn(name="supplier_id", nullable=false)
	private Supplier supplier;
	
	@Column(name = "amount_material")
	private Float amountMaterial;

	
	@Column(name = "CreatedAt")
	private Date createdAt;

}
