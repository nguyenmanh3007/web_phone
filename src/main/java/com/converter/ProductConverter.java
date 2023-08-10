package com.converter;

import org.springframework.stereotype.Component;

import com.dto.ProductDTO;
import com.model.Product;

@Component
public class ProductConverter {
	public ProductDTO toDTO(Product product) {
		ProductDTO productDTO=ProductDTO.builder()
				.code(product.getCode())
				.name(product.getName())
				.price(product.getPrice())
				.tag(product.getTag())
				.be_price(product.getBe_price())
				.des(product.getDes())
				.img(product.getImg())
				.model(product.getModel())
				.configuration(product.getConfiguration())
				.quantity(product.getQuantity())
				.build();
		return productDTO;
	}
	public Product toEntity(ProductDTO productDTO) {
		Product product=Product.builder()
				.code(productDTO.getCode())
				.name(productDTO.getName())
				.price(productDTO.getPrice())
				.tag(productDTO.getTag())
				.be_price(productDTO.getBe_price())
				.des(productDTO.getDes())
				.img(productDTO.getImg())
				.model(productDTO.getModel())
				.configuration(productDTO.getConfiguration())
				.quantity(productDTO.getQuantity())
				.build();
		return product;
	}
	public Product toEntity(Product productR,ProductDTO productDTO) {
		Product product=Product.builder()
				.code(productR.getCode())
				.name(productDTO.getName())
				.price(productDTO.getPrice())
				.tag(productDTO.getTag())
				.be_price(productDTO.getBe_price())
				.des(productDTO.getDes())
				.img(productDTO.getImg())
				.model(productDTO.getModel())
				.configuration(productDTO.getConfiguration())
				.quantity(productDTO.getQuantity())
				.build();
		return product;
	}
}
