package com.thuctapcdit.qlnguyenlieube.model;

import java.time.LocalDate;
import java.util.Date;

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
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
@EntityListeners(AuditingEntityListener.class)
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "gender")
	private String gender;
	
	@Column(name = "birth")
	private LocalDate birth;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "status")
	private Integer status;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "token")
	private String token;
	
	@Column(name = "token_expired")
	private Date tokenExpired;

	@CreatedDate
	@Column(name = "created_at")
	private Date createdAt;

	@LastModifiedDate
	@Column(name = "updated_at")
	private Date updatedAt;
	
}
