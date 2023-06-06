package com.dto;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO extends AbstractDTO<ProductDTO> {
	private String code;
	private String name;
	private String price;
	private String tag;
	private int be_price;
	private String des;
	private String img;
	private String model;
	private String configuration;
	private int quantity;
	private List<ProductDTO> listResultTwo =new ArrayList<>();;
	
	public List<ProductDTO> getListResultTwo() {
		return listResultTwo;
	}
	public void setListResultTwo(List<ProductDTO> listResultTwo) {
		this.listResultTwo = listResultTwo;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public int getBe_price() {
		return be_price;
	}
	public void setBe_price(int be_price) {
		this.be_price = be_price;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getConfiguration() {
		return configuration;
	}
	public void setConfiguration(String configuration) {
		this.configuration = configuration;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
	
	