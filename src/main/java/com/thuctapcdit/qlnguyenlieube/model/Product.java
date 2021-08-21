package com.thuctapcdit.qlnguyenlieube.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
@EntityListeners(AuditingEntityListener.class)
public class Product {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "image")
	private String image;

	@Column(name = "amount")
	private Float amount;

	@Column(name = "status")
	private Integer status;

	@CreatedDate
	@Column(name = "created_at")
	private Date createdAt;

	@LastModifiedDate
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@OneToMany(mappedBy="product")
    private List<ProductMaterial> productMaterials;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
}
