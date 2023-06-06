package com.service;

import java.util.List;

import com.dto.ProductDTO;
import com.model.Product;

public interface ProductMethod {
	List<Product> findAll();
	List<ProductDTO> findAllProductDTO();
	List<Product> findByQuantity(int quan);
	List<ProductDTO> findByQuantityProductDTO(int quan);
	List<Product> getProductByQuantity();

	void delete(Product product);
	void deleteByCode(String code);

	void save(Product product);

	Product findByCode(String code);

	List<Product> findByModel(String mode);

	List<Product> findByConfiguration(String mode);

	List<Product> findByPrice1(int price1, int price2);

	List<Product> findByModelAndConfiguration(String mode, String con);

	List<Product> findByModelAndPrice1(String mode, int price1, int price2);

	List<Product> findByConfigurationAndPrice1(String con, int price1, int price2);

	List<Product> findByModelAndConfigurationAndPrice1(String mode, String con, int price1, int price2);
	ProductDTO create_update(ProductDTO productDTO);
}
