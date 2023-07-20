package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Repository.ProductRepository;
import com.converter.ProductConverter;
import com.dto.ProductDTO;
import com.model.Product;

@Service
public class ProductMethodImpl implements ProductMethod{
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductConverter productConverter;
	
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}
	@Override
	public List<Product> findByQuantity(int quan) {
		// TODO Auto-generated method stub
		return productRepository.findByQuantity(quan);
	}
	@Override
	public List<Product> getProductByQuantity() {
		return productRepository.getProductByQuantity();
	}
	
	@Override
	@Transactional
	public void delete(Product product) {
		// TODO Auto-generated method stub
		productRepository.delete(product);
	}
	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
	}
	@Override
	@Transactional
	public Product findByCode(String code) {
		// TODO Auto-generated method stub
		return productRepository.findByCode(code);
	}
	@Override
	public List<Product> findByModel(String mode) {
		// TODO Auto-generated method stub
		return productRepository.findByModel(mode);
	}
	@Override
	public List<Product> findByConfiguration(String mode) {
		// TODO Auto-generated method stub
		return productRepository.findByConfiguration(mode);
	}
	@Override
	public List<Product> findByPrice1(int price1, int price2) {
		return productRepository.findByPrice1(price1, price2);
	}
	@Override
	public List<Product> findByModelAndConfiguration(String mode,String con) {
		// TODO Auto-generated method stub
		return productRepository.findByModelAndConfiguration(mode,con);
	}
	@Override
	public List<Product> findByModelAndPrice1(String mode, int price1,int price2) {
		return productRepository.findByModelAndPrice1(mode, price1, price2);
	}
	@Override
	public List<Product> findByConfigurationAndPrice1(String con, int price1, int price2) {
		return productRepository.findByConfigurationAndPrice1(con, price1, price2);
	}
	@Override
	public List<Product> findByModelAndConfigurationAndPrice1(String mode, String con, int price1, int price2) {
		return productRepository.findByModelAndConfigurationAndPrice1(mode, con, price1, price2);
	}
	@Override
	@Transactional
	public ProductDTO create_update(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		Product product= new Product();
		if(productRepository.findByCode(productDTO.getCode())==null) {
			product=productConverter.toEntity(productDTO);
		}
		else {
			Product oldproduct=productRepository.findByCode(productDTO.getCode());
			product= productConverter.toEntity(oldproduct, productDTO);
		}
		return productConverter.toDTO(productRepository.save(product));
	}
	@Override
	@Transactional
	public void deleteByCode(String code) {
		// TODO Auto-generated method stub
		productRepository.deleteByCode(code);
	}
	@Override
	public List<ProductDTO> findAllProductDTO() {
		// TODO Auto-generated method stub
		List<ProductDTO> lresult= new ArrayList<>();
		List<Product> products= productRepository.findAll();
		for(Product p: products) {
			if(p.getQuantity()>0) {
				lresult.add(productConverter.toDTO(p));
			}
		}
		return lresult;
	}
	@Override
	public List<ProductDTO> findByQuantityProductDTO(int quan) {
		List<ProductDTO> lresult= new ArrayList<>();
		List<Product> products= productRepository.findByQuantity(0);
		for(Product p: products) {
			lresult.add(productConverter.toDTO(p));
		}
		return lresult;
	}

}
