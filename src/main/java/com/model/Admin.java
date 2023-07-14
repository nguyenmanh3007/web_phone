package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="admin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
	@Id
	@Column(name="id",nullable = false)
	private int id;
	@Column(name="username",nullable=false)
	private String username;
	@Column(name="password",nullable=false)
	private String password;
	@Column(name="fullname",nullable=false)
	private String fullname;
	@Column(name="email",nullable=false)
	private String email;
	@Column(name="phone",nullable=false)
	private String phone;
}
