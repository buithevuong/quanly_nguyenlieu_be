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
@Table(name = "material")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
public class Material {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "Name")
	private String name;

	@Column(name = "Image")
	private String image;

	@Column(name = "currentAmount")
	private Float currentAmount;

	@Column(name = "total")
	private Float total;

	@Column(name = "Status")
	private Integer status;

	@Column(name = "CreatedAt")
	private Date createdAt;

	@Column(name = "UpdatedAt")
	private Date updatedAt;
	
    @OneToMany(mappedBy="material", fetch = FetchType.LAZY)
    private Set<MaterialSupplier> materialSuppliers;

    @OneToMany(mappedBy="material", fetch = FetchType.LAZY)
    private Set<MaterialWarning> materialWarnings;
    
    @OneToMany(mappedBy="material", fetch = FetchType.LAZY)
    private Set<ProductMaterial> productMaterials;
}
