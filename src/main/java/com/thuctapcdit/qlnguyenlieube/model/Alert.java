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
@Table(name = "alert")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
@EntityListeners(AuditingEntityListener.class)
public class Alert {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "color")
	private String color;

	@CreatedDate
	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "is_checked")
	private Integer isChecked;

	@ManyToOne(optional=false , fetch = FetchType.LAZY)
	@JoinColumn(name="material_id", nullable=false)
	private Material material;
}
