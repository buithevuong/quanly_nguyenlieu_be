package com.thuctapcdit.qlnguyenlieube.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
//@JsonInclude(Include.NON_NULL)
public class Material {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "image")
	private String image;

	@Column(name = "current_amount")
	private Float currentAmount;

	@Column(name = "total_amount")
	private Float total;

	@Column(name = "status")
	private Integer status;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "updated_at")
	private Date updatedAt;
	
    @OneToMany(mappedBy="material")
    private List<MaterialSupplier> materialSuppliers;

    @OneToMany(mappedBy="material")
    private List<MaterialWarning> materialWarnings;
    
    @OneToMany(mappedBy="material")
    private List<ProductMaterial> productMaterials;
    
    @OneToOne
	@JoinColumn(name="user_id")
	private User user;
}
