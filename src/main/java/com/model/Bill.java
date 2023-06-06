package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bill")
public class Bill {
	@Id
	@Column(name="idbill", nullable=false)
	private int idbill;
	@Column(name="country", nullable=false)
	private String country;
	@Column(name="city", nullable=false)
	private String city;
	@Column(name="county", nullable=false)
	private String county;
	@Column(name="hn", nullable=false)
	private String hn;
	@Column(name="phone", nullable=false)
	private String phone;
	@Column(name="date", nullable=false)
	private String date;
	@Column(name="total", nullable=false)
	private int total;
	@Column(name="username", nullable=false)
	private String username;
	@Column(name="products", nullable=false)
	private String products;
	@Column(name="status", nullable=false)
	private int status;
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Bill(int idbill, String country, String city, String county, String hn, String phone, String date,
			int total, String username, String products, int status) {
		super();
		this.idbill = idbill;
		this.country = country;
		this.city = city;
		this.county = county;
		this.hn = hn;
		this.phone = phone;
		this.date = date;
		this.total = total;
		this.username = username;
		this.products = products;
		this.status = status;
	}

	public Bill(int idbill, String country, String city, String county, String hn, String phone, String date,
			int total, String username, String products) {
		super();
		this.idbill = idbill;
		this.country = country;
		this.city = city;
		this.county = county;
		this.hn = hn;
		this.phone = phone;
		this.date = date;
		this.total = total;
		this.username = username;
		this.products = products;
	}
	public int getIdbill() {
		return idbill;
	}
	public void setIdbill(int idbill) {
		this.idbill = idbill;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getHn() {
		return hn;
	}
	public void setHn(String hn) {
		this.hn = hn;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getProducts() {
		return products;
	}
	public void setProducts(String products) {
		this.products = products;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	
}
