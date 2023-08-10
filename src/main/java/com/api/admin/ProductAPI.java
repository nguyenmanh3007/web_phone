package com.api.admin;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.dto.ProductDTO;
import com.model.Product;
import com.service.ProductMethod;

@RestController(value = "productOfAdmin")
@RequiredArgsConstructor
public class ProductAPI {
	private final ProductMethod productMethod;
	@PostMapping("/api/product")
	public ResponseEntity<?> createProduct(@ModelAttribute("product") ProductDTO productDTO,@RequestParam("image") MultipartFile file,HttpSession session) throws  IOException {
		Product oldProduct = productMethod.findByCode(productDTO.getCode());
		if(productDTO.getCode() != "" && oldProduct == null) {
            String path ="C:/Users/PV/Documents/workspace-spring-tool-suite-4-4.14.1.RELEASE/webbanhang/src/main/resources/static/img";
            String ext = FilenameUtils.getExtension(file.getOriginalFilename());
            String filename = UUID.randomUUID().toString();
            File f1 = new File(path + "/" + filename + "." + ext);
            file.transferTo(f1);
            productDTO.setImg("img/"+filename + "." + ext);
			return ResponseEntity.ok(productMethod.create_update(productDTO));
		}
		else {
			return ResponseEntity.badRequest().body("Product already exists");
		}
	}
	@PutMapping("/api/product")
	public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
		return productMethod.create_update(productDTO);
	}
	@DeleteMapping("/api/product")
	public void deleteProduct(@RequestBody String ids) {
			String id= ids.substring(1,ids.length()-1);
			Product product= productMethod.findByCode(id);
			productMethod.delete(product);
	}
	@GetMapping("/api/product")
	public ProductDTO getListProduct(){
		ProductDTO productDTO= new ProductDTO();
		productDTO.setListResult(productMethod.findAllProductDTO());
		productDTO.setListResultTwo(productMethod.findByQuantityProductDTO(0));
		return productDTO;
	}
}
