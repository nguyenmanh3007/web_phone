package com.Controller.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.Bill;
import com.model.Carts;
import com.service.BillMethod;
import com.service.CartMethod;

@Controller(value = "billControllerOfWeb")
public class BillController {
	@Autowired
	private BillMethod billMethod;
	@Autowired
	private CartMethod cartMethod;
	
	@GetMapping("/user-order")
	public ModelAndView rabill(HttpSession session) {
		String username= (String) session.getAttribute("user");
		List<Bill> list= billMethod.getBillByUser(username);
		ModelAndView mav = new ModelAndView("order");
		mav.addObject("listBill", list);
		List<Carts> listOne= cartMethod.getInfoCart(username);
		int sumT = 0;
		for(Carts carts: listOne) {
			sumT += carts.getTotal();
		}
		mav.addObject("sumT", sumT);
		int a = cartMethod.getCountCart(username);
		mav.addObject("cCart", a);
		mav.addObject("username", username);
		return mav;
	}
}
