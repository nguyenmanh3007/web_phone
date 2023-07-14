package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

	@Id
	@Column(name="idcart",nullable=false)
	private int idcart;
	@Column(name="username",nullable=false)
	private String username;
	@Column(name="idproduct",nullable=false)
	private String idproduct;
	@Column(name="num",nullable=false)
	private int num;
	@Column(name="total",nullable=false)
	private int total;
}
