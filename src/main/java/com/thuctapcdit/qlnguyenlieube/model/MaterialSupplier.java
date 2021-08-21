package com.thuctapcdit.qlnguyenlieube.model;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "material_supplier")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
@Slf4j
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

	@CreatedDate
	@Column(name = "CreatedAt")
	private Date createdAt;

}
