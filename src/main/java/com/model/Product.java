package com.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="product")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "product",cascade = CascadeType.ALL)
	@JsonIgnore
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<Cart> carts=new HashSet<>();
}
