package com.Controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dto.cartDTO;
import com.model.Bill;
import com.model.Product;
import com.service.CartMethod;
import com.service.ProductMethod;

@Controller(value = "cartControllerOfWeb")
public class CartController {
	@Autowired
	private ProductMethod productMethod;
	@Autowired
	private CartMethod cartMethod;
	
	@GetMapping("/add-to-cart")
	public String shoppage(Model model, HttpSession session, HttpServletRequest request) {
		Iterable<Product> listPro= productMethod.getProductByQuantity();
		model.addAttribute("listProduct", listPro);
		String name= (String) session.getAttribute("user");
		List<cartDTO> list= cartMethod.getInfoCart(name);
		int sumT=0;
		for(cartDTO cartDTO:list) {
			sumT+=cartDTO.getTotal();
		}
		model.addAttribute("sumT", sumT);
		int a = cartMethod.getCountCart(name);
		model.addAttribute("cCart", a);
		model.addAttribute("username", name);
		if(request.getParameter("message") != null) {
			if(request.getParameter("message").equals("insert_success")) {
				model.addAttribute("message", "add to cart success!!!");
			}
		}
		return "usershop";	
	}
	@GetMapping("/user-cart")
	public String cart(Model model,HttpSession session) {
		String name= (String) session.getAttribute("user");
		List<cartDTO> list= cartMethod.getInfoCart(name);
		model.addAttribute("listCart", list);
		model.addAttribute("username", name);
		int sumT = 0;
		for(cartDTO cartDTO: list) {
			sumT += cartDTO.getTotal();
		}
		model.addAttribute("sumT", sumT);
		int a = cartMethod.getCountCart(name);
		model.addAttribute("cCart", a);
		return "cart";
	}
	@GetMapping("/user-checkout")
	public String checkoutform(Model model,HttpSession session) {
		String name= (String) session.getAttribute("user");
		List<cartDTO> list= cartMethod.getInfoCart(name);
		model.addAttribute("listCart", list);
		int sumT = 0;
		for(cartDTO cartDTO: list) {
			sumT += cartDTO.getTotal();
		}
		model.addAttribute("sumT", sumT);
		int a = cartMethod.getCountCart(name);
		model.addAttribute("cCart", a);
		model.addAttribute("bill", new Bill());
		model.addAttribute("username", name);
		return "checkout";
	}
}
