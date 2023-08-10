package com.service;

import java.util.List;
import java.util.stream.Collectors;

import com.filter.FormData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Repository.ProductRepository;
import com.converter.ProductConverter;
import com.dto.ProductDTO;
import com.model.Product;

@Service
@RequiredArgsConstructor
public class ProductMethodImpl implements ProductMethod{
	private final ProductRepository productRepository;
	private final ProductConverter productConverter;
	
	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	@Override
	public List<Product> findByQuantity(int quan) {
		return productRepository.findByQuantity(quan);
	}
	@Override
	public List<Product> getProductByQuantity() {
		return productRepository.getProductByQuantity();
	}

	@Override
	public ProductDTO filterProductByModelAndConfigurationAndPrice(FormData formData) {
		ProductDTO productDTO = new ProductDTO();
		if(formData.getType().equals("Cancel") && formData.getConfiguration().equals("Cancel") && formData.getCost().equals("Cancel")) {
			productDTO.setListResult(toListProductDTO(findAll()));
		}
		else if(formData.getConfiguration().equals("Cancel") && formData.getCost().equals("Cancel")) {
			productDTO.setListResult(toListProductDTO(findByModel(formData.getType())));
		}
		else if(formData.getType().equals("Cancel") && formData.getCost().equals("Cancel")) {
			productDTO.setListResult(toListProductDTO(findByConfiguration(formData.getConfiguration())));
		}
		else if(formData.getType().equals("Cancel") && formData.getConfiguration().equals("Cancel")) {
			String gia[]=formData.getCost().split("-");
			int gia1=Integer.parseInt(gia[0]);
			int gia2=Integer.parseInt(gia[1]);
			productDTO.setListResult(toListProductDTO(findByPrice(gia1, gia2)));
		}
		else if(formData.getCost().equals("Cancel")) {
			productDTO.setListResult(toListProductDTO(findByModelAndConfiguration(formData.getType(), formData.getConfiguration())));
		}
		else if(formData.getConfiguration().equals("Cancel")) {
			String gia0[]= formData.getCost().split("-");
			int gia11=Integer.parseInt(gia0[0]);
			int gia21=Integer.parseInt(gia0[1]);
			productDTO.setListResult(toListProductDTO(findByModelAndPrice(formData.getType(),gia11, gia21)));
		}
		else if(formData.getType().equals("Cancel")) {
			String gia02[]= formData.getCost().split("-");
			int gia12=Integer.parseInt(gia02[0]);
			int gia22=Integer.parseInt(gia02[1]);
			productDTO.setListResult(toListProductDTO(findByConfigurationAndPrice(formData.getConfiguration(),gia12, gia22)));
		}
		else {
			String gia02[]= formData.getCost().split("-");
			int gia12=Integer.parseInt(gia02[0]);
			int gia22=Integer.parseInt(gia02[1]);
			productDTO.setListResult(toListProductDTO(findByModelAndConfigurationAndPrice(formData.getType(),formData.getConfiguration(),gia12, gia22)));
		}
		return productDTO;
	}
	private List<ProductDTO> toListProductDTO(List<Product> list){
		return list.stream().filter(product -> product.getQuantity()>0).map(product -> productConverter.toDTO(product))
				.collect(Collectors.toList());
	}

	@Override
	@Transactional
	public void delete(Product product) {
		productRepository.delete(product);
	}
	@Override
	public void save(Product product) {
		productRepository.save(product);
	}
	@Override
	@Transactional
	public Product findByCode(String code) {
		return productRepository.findByCode(code);
	}
	@Override
	public List<Product> findByModel(String mode) {
		return productRepository.findByModel(mode);
	}
	@Override
	public List<Product> findByConfiguration(String mode) {
		return productRepository.findByConfiguration(mode);
	}
	@Override
	public List<Product> findByPrice(int price1, int price2) {
		return productRepository.findByPrice1(price1, price2);
	}
	@Override
	public List<Product> findByModelAndConfiguration(String mode,String con) {
		return productRepository.findByModelAndConfiguration(mode,con);
	}
	@Override
	public List<Product> findByModelAndPrice(String mode, int price1,int price2) {
		return productRepository.findByModelAndPrice(mode, price1, price2);
	}
	@Override
	public List<Product> findByConfigurationAndPrice(String con, int price1, int price2) {
		return productRepository.findByConfigurationAndPrice(con, price1, price2);
	}
	@Override
	public List<Product> findByModelAndConfigurationAndPrice(String mode, String con, int price1, int price2) {
		return productRepository.findByModelAndConfigurationAndPrice(mode, con, price1, price2);
	}
	@Override
	@Transactional
	public ProductDTO create_update(ProductDTO productDTO) {
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
		productRepository.deleteByCode(code);
	}
	@Override
	public List<ProductDTO> findAllProductDTO() {
		List<Product> products= productRepository.findAll();
		return products.stream().filter(product -> product.getQuantity()>0)
				.map(product -> productConverter.toDTO(product)).collect(Collectors.toList());
	}
	@Override
	public List<ProductDTO> findByQuantityProductDTO(int quan) {
		List<Product> products= productRepository.findByQuantity(0);
		return products.stream().map(product -> productConverter.toDTO(product)).collect(Collectors.toList());
	}

}
