package com.thuctapcdit.qlnguyenlieube.model;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "material_warning")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
@EntityListeners(AuditingEntityListener.class)
public class MaterialWarning {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(optional=false, fetch = FetchType.LAZY)
    @JoinColumn(name="material_id", nullable=false)
	private Material material;
	
	@ManyToOne(optional=false, fetch = FetchType.LAZY)
    @JoinColumn(name="warning_threshold_id", nullable=false)
	private WarningThreshold warningThreshold;

	@CreatedDate
	@Column(name = "created_at")
	private Date createdAt;
}
