package com.converter;

import org.springframework.stereotype.Component;

import com.dto.ProductDTO;
import com.model.Product;

@Component
public class ProductConverter {
	public ProductDTO toDTO(Product product) {
		ProductDTO dto = new ProductDTO();
		dto.setCode(product.getCode());
		dto.setName(product.getName());
		dto.setPrice(product.getPrice());
		dto.setTag(product.getTag());
		dto.setBe_price(product.getBe_price());
		dto.setDes(product.getDes());
		dto.setImg(product.getImg());
		dto.setModel(product.getModel());
		dto.setConfiguration(product.getConfiguration());
		dto.setQuantity(product.getQuantity());
		return dto;
	}
	public Product toEntity(ProductDTO product) {
		Product dto = new Product();
		dto.setCode(product.getCode());
		dto.setName(product.getName());
		dto.setPrice(product.getPrice());
		dto.setTag(product.getTag());
		dto.setBe_price(product.getBe_price());
		dto.setDes(product.getDes());
		dto.setImg(product.getImg());
		dto.setModel(product.getModel());
		dto.setConfiguration(product.getConfiguration());
		dto.setQuantity(product.getQuantity());
		return dto;
	}
	public Product toEntity(Product dto,ProductDTO product) {
		dto.setName(product.getName());
		dto.setPrice(product.getPrice());
		dto.setTag(product.getTag());
		dto.setBe_price(product.getBe_price());
		dto.setDes(product.getDes());
		dto.setImg(product.getImg());
		dto.setModel(product.getModel());
		dto.setConfiguration(product.getConfiguration());
		dto.setQuantity(product.getQuantity());
		return dto;
	}
}
