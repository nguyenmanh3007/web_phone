package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {
	@Id
	@Column(name="id", nullable=false)
	private String code;
	@Column(name="name", nullable=false)
	private String name;
	@Column(name="price", nullable=false)
	private String price;
	@Column(name="tag", nullable=false)
	private String tag;
	@Column(name="be_price", nullable=false)
	private int be_price;
	@Column(name="des", nullable=false)
	private String des;
	@Column(name="img")
	private String img;
	@Column(name="model", nullable=false)
	private String model;
	@Column(name="configuration", nullable=false)
	private String configuration;
	@Column(name="quantity", nullable=false)
	private int quantity;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String code, String name, String price, String tag, int be_price, String des, String img,
			String model, String configuration, int quantity) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.tag = tag;
		this.be_price = be_price;
		this.des = des;
		this.img = img;
		this.model = model;
		this.configuration = configuration;
		this.quantity = quantity;
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
