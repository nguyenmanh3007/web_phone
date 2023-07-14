package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="bill")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
