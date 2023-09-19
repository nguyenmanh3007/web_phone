package com.Controller.web;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dto.CartDTO;
import com.model.Bill;
import com.service.BillMethod;
import com.service.CartMethod;

@Controller(value = "billControllerOfWeb")
@RequiredArgsConstructor
public class BillController {
	private final BillMethod billMethod;
	private final CartMethod cartMethod;
	
	@GetMapping("/user-order")
	public ModelAndView getOrderBill(HttpSession session) {
		String username= (String) session.getAttribute("user");
		List<Bill> list= billMethod.getBillByUser(username);
		ModelAndView mav = new ModelAndView("order");
		mav.addObject("listBill", list);
		List<CartDTO> listOne= cartMethod.getInfoCart(username);
		int sumT = 0;
		for(CartDTO cartDTO: listOne) {
			sumT += cartDTO.getTotal();
		}
		mav.addObject("sumT", sumT);
		int a = cartMethod.getCountCart(username);
		mav.addObject("cCart", a);
		mav.addObject("username", username);
		return mav;
	}
}
