package com.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
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
}
	
	