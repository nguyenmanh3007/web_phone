package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cart")
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
	public Cart(int idcart, String username, String idproduct, int num, int total) {
		super();
		this.idcart = idcart;
		this.username = username;
		this.idproduct = idproduct;
		this.num = num;
		this.total = total;
	}
	public Cart() {
		super();
	}
	public int getIdcart() {
		return idcart;
	}
	public void setIdcart(int idcart) {
		this.idcart = idcart;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIdproduct() {
		return idproduct;
	}
	public void setIdproduct(String idproduct) {
		this.idproduct = idproduct;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
}
