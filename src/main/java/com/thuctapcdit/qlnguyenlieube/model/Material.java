package com.thuctapcdit.qlnguyenlieube.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "material")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
//@JsonInclude(Include.NON_NULL)
public class Material {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private String type;

	@Column(name = "image")
	private String image;

	@Column(name = "current_amount")
	private Float currentAmount;

	@Column(name = "total_amount")
	private Float total;

	@Column(name = "status")
	private Integer status;

	@CreatedDate
	@Column(name = "created_at")
	private Date createdAt;

	@LastModifiedDate
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
