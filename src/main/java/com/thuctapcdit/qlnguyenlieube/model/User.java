package com.thuctapcdit.qlnguyenlieube.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Name")
	private String name;

	@Column(name = "Gender")
	private String gender;
	
	@Column(name = "Birth")
	private LocalDate birth;
	
	@Column(name = "Phone")
	private String phone;
	
	@Column(name = "Email")
	private String email;
	
	@Column(name = "Status")
	private Integer status;
	
	@Column(name = "Pasword")
	private String password;
	
	@Column(name = "Token")
	private String token;
	
	@Column(name = "TokenExpired")
	private Date tokenExpired;
	
	@Column(name = "CreatedAt")
	private Date createdAt;

	@Column(name = "UpdatedAt")
	private Date updatedAt;
}
