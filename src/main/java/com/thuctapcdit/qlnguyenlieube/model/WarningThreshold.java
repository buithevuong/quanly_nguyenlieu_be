package com.thuctapcdit.qlnguyenlieube.model;

import java.util.Date;
import java.util.Set;

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
@Table(name = "warning_threshold")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
@EntityListeners(AuditingEntityListener.class)
public class WarningThreshold {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "thresh_hold")
	private Float threshold;
	
	@Column(name = "color")
	private String color;

	@CreatedDate
	@Column(name = "created_at")
	private Date createdAt;

	@LastModifiedDate
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@OneToMany(mappedBy="warningThreshold", fetch = FetchType.LAZY)
    private Set<MaterialWarning> materialWarnings;
}
