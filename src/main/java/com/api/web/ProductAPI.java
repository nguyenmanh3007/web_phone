package com.api.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.dto.ProductDTO;
import com.filter.FormData;
import com.service.ProductMethod;

@RestController
@RequiredArgsConstructor
public class ProductAPI {
	private final ProductMethod productMethod;
	@PostMapping("api/web/product")
	public ProductDTO filterProduct(@RequestBody FormData formData ) {
		return productMethod.filterProductByModelAndConfigurationAndPrice(formData);
	}

}
