package com.Controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.ProductDTO;
import com.google.gson.Gson;
import com.model.Product;
import com.service.ProductMethod;
import com.utils.MessageUtil;

@Controller(value = "productControllerOfAdmin")
@RequiredArgsConstructor
public class ProductController {
	private final ProductMethod productMethod;
	private final MessageUtil messageUtil;
	
	@GetMapping("/admin/listProduct")
	public ModelAndView listProduct(@RequestParam(name = "ProductDTO", required = false) String productDTO,HttpSession session) {
		ModelAndView mav= new ModelAndView("listProduct");
		mav.addObject("username", session.getAttribute("username"));
		if (productDTO != null) {
            Gson gson = new Gson();
            ProductDTO pDto = gson.fromJson(productDTO, ProductDTO.class);
            mav.addObject("listProduct", pDto.getListResult());
            mav.addObject("listProduct1", pDto.getListResultTwo());
        }
		return mav;
	}
	@GetMapping("/admin/product/{code}/edit")
	public ModelAndView editProductTran(@PathVariable String code) {
		ModelAndView mav= new ModelAndView("edit_addProduct");
		Product product = productMethod.findByCode(code);
		mav.addObject("product", product);
		mav.addObject("oldId",product.getCode());
		return mav;
	}
	@GetMapping("/admin/addProduct")
	public ModelAndView addProductTran() {
		ModelAndView mav= new ModelAndView("edit_addProduct");
		mav.addObject("product", new Product());
		return mav;
	}

	@GetMapping("/admin/addOrUpdateProduct")
	public ModelAndView addOrUpdateProduct(HttpServletRequest request,HttpSession session) {
		ModelAndView mav= new ModelAndView("listProduct");
		if(request.getParameter("message")!=null) {
	    	  Map<String,String> message= messageUtil.getMessage(request.getParameter("message"));
	    	  System.out.println(message);
	    	  mav.addObject("message", message.get("message"));
	    	  mav.addObject("alert",message.get("alert"));
	      }
		mav.addObject("username", session.getAttribute("username"));
		mav.addObject("listProduct1", productMethod.findByQuantity(0));
		mav.addObject("listProduct", productMethod.getProductByQuantity());
		return mav;
	}
}
