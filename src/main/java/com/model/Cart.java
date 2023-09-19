package com.model;

import javax.persistence.*;

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
	@Column(name="idCart",nullable=false)
	private int idCart;
	@Column(name="num",nullable=false)
	private int num;
	@Column(name="total",nullable=false)
	private int total;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId",nullable = false)
	private User user;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "productId",nullable = false)
	private Product product;
}
