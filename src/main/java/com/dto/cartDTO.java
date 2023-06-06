package com.dto;

import com.model.Cart;

public class cartDTO extends AbstractDTO<Cart> {
	private int idcart;
	private String username;
	private String idproduct;
	private int num;
	private int total;
	
	public cartDTO() {
		// TODO Auto-generated constructor stub
	}

	public cartDTO(int idcart, String username, String idproduct, int num, int total) {
		super();
		this.idcart = idcart;
		this.username = username;
		this.idproduct = idproduct;
		this.num = num;
		this.total = total;
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
