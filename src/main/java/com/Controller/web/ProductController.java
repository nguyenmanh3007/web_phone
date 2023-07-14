package com.Controller.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.ProductDTO;
import com.google.gson.Gson;

@Controller(value = "productControllerOfWeb")
public class ProductController {
	@GetMapping("/filterProduct")
	public ModelAndView fil(@RequestParam(name = "ProductDTO", required = false) String productDTO,HttpSession session) {
		ModelAndView mav= new ModelAndView("usershop");
		mav.addObject("username", session.getAttribute("user"));
		if (productDTO != null) {
            Gson gson = new Gson();
            ProductDTO pDto = gson.fromJson(productDTO, ProductDTO.class);
            mav.addObject("listProduct", pDto.getListResult());
        }
		return mav;
	}
}
