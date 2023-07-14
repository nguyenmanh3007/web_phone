package com.model;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carts {
	@Id
	@Column(name="idcart",nullable=false)
	private int idcart;
	@Column(name="username",nullable=false)
	private String username;
	@Column(name="idproduct",nullable=false)
	private String idproduct;
	@Column(name="num",nullable=false)
	private int num;
	private String nameproduct;
	private int price;
	@Column(name="total",nullable=false)
	private int total;
}
