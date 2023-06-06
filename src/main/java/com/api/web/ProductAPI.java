package com.api.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.converter.ProductConverter;
import com.dto.ProductDTO;
import com.filter.FormData;
import com.model.Product;
import com.service.ProductMethod;

@RestController
public class ProductAPI {
	@Autowired
	private ProductMethod productMethod;
	@Autowired
	private ProductConverter productConverter;
	@PostMapping("api/web/product")
	public ProductDTO filter(@RequestBody FormData formData ) {
		ProductDTO productDTO = new ProductDTO();
		if(formData.getType().equals("Cancel") && formData.getConfiguration().equals("Cancel") && formData.getCost().equals("Cancel")) {
			productDTO.setListResult(toListDTO(productMethod.findAll()));
		}
		else if(formData.getConfiguration().equals("Cancel") && formData.getCost().equals("Cancel")) {
			productDTO.setListResult(toListDTO(productMethod.findByModel(formData.getType())));
		}
		else if(formData.getType().equals("Cancel") && formData.getCost().equals("Cancel")) {
			productDTO.setListResult(toListDTO(productMethod.findByConfiguration(formData.getConfiguration())));
		}
		else if(formData.getType().equals("Cancel") && formData.getConfiguration().equals("Cancel")) {
			String gia[]=formData.getCost().split("-");
			int gia1=Integer.parseInt(gia[0]);
			int gia2=Integer.parseInt(gia[1]);
			productDTO.setListResult(toListDTO(productMethod.findByPrice1(gia1, gia2)));
		}
		else if(formData.getCost().equals("Cancel")) {
			productDTO.setListResult(toListDTO(productMethod.findByModelAndConfiguration(formData.getType(), formData.getConfiguration())));
		}
		else if(formData.getConfiguration().equals("Cancel")) {
			String gia0[]= formData.getCost().split("-");
			int gia11=Integer.parseInt(gia0[0]);
			int gia21=Integer.parseInt(gia0[1]);
			productDTO.setListResult(toListDTO(productMethod.findByModelAndPrice1(formData.getType(),gia11, gia21)));
		}
		else if(formData.getType().equals("Cancel")) {
			String gia02[]= formData.getCost().split("-");
			int gia12=Integer.parseInt(gia02[0]);
			int gia22=Integer.parseInt(gia02[1]);
			productDTO.setListResult(toListDTO(productMethod.findByConfigurationAndPrice1(formData.getConfiguration(),gia12, gia22)));
		}
		else {
			String gia02[]= formData.getCost().split("-");
			int gia12=Integer.parseInt(gia02[0]);
			int gia22=Integer.parseInt(gia02[1]);
			productDTO.setListResult(toListDTO(productMethod.findByModelAndConfigurationAndPrice1(formData.getType(),formData.getConfiguration(),gia12, gia22)));
		}
		return productDTO;
		
	}
	private List<ProductDTO> toListDTO(List<Product> list){
		List<ProductDTO> lDto= new ArrayList<>();
		for( Product p:list) {
			if(p.getQuantity()>0) {
				lDto.add(productConverter.toDTO(p));
			}
		}
		return lDto;
	}
}
