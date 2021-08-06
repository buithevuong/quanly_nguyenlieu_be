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
@Table(name = "warningthreshold")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
public class WarningThreshold {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Threshold")
	private Float threshold;
	
	@Column(name = "Color")
	private String color;
	
	@Column(name = "CreatedAt")
	private Date createdAt;
	
	@Column(name = "UpdatedAt")
	private Date updatedAt;
	
	@OneToMany(mappedBy="warningThreshold", fetch = FetchType.LAZY)
    private Set<MaterialWarning> materialWarnings;
}
