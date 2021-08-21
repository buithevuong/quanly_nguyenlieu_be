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
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "supplier")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
@Slf4j
public class Supplier {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

//	@Column(name = "Image")
//	private String image;

	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "status")
	private Integer status;

	@CreatedDate
	@Column(name = "created_at")
	private Date createdAt;

	@LastModifiedDate
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@OneToMany(mappedBy="supplier" , fetch = FetchType.LAZY)
    private List<MaterialSupplier> materialSuppliers;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
}
