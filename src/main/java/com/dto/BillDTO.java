package com.dto;

import java.util.ArrayList;
import java.util.List;

public class BillDTO extends AbstractDTO<BillDTO> {
	private int idbill;
	private String country;
	private String city;
	private String county;
	private String hn;
	private String phone;
	private String date;
	private int total;
	private String username;
	private String products;
	private int status;
	private List<BillDTO> listResultTwo = new ArrayList<>();
	private List<BillDTO> listResultThree = new ArrayList<>();
	
	public List<BillDTO> getListResultThree() {
		return listResultThree;
	}
	public void setListResultThree(List<BillDTO> listResultThree) {
		this.listResultThree = listResultThree;
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
	public List<BillDTO> getListResultTwo() {
		return listResultTwo;
	}
	public void setListResultTwo(List<BillDTO> listResultTwo) {
		this.listResultTwo = listResultTwo;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
