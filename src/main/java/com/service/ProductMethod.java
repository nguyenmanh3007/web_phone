package com.service;

import java.util.List;

import com.dto.ProductDTO;
import com.filter.FormData;
import com.model.Product;

public interface ProductMethod {
	List<Product> findAll();
	List<ProductDTO> findAllProductDTO();
	List<Product> findByQuantity(int quan);
	List<ProductDTO> findByQuantityProductDTO(int quan);
	List<Product> getProductByQuantity();

	ProductDTO filterProductByModelAndConfigurationAndPrice(FormData formData);

	void delete(Product product);
	void deleteByCode(String code);

	void save(Product product);

	Product findByCode(String code);

	List<Product> findByModel(String mode);

	List<Product> findByConfiguration(String mode);

	List<Product> findByPrice(int price1, int price2);

	List<Product> findByModelAndConfiguration(String mode, String con);

	List<Product> findByModelAndPrice(String mode, int price1, int price2);

	List<Product> findByConfigurationAndPrice(String con, int price1, int price2);

	List<Product> findByModelAndConfigurationAndPrice(String mode, String con, int price1, int price2);
	ProductDTO create_update(ProductDTO productDTO);
}
