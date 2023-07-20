package com.Controller.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.BillDTO;
import com.google.gson.Gson;
import com.model.Bill;
import com.service.BillMethod;

@Controller(value = "billControllerOfAdmin")
public class BillController {
	@Autowired
	private BillMethod billMethod;
	@GetMapping("/admin/billT")
	public ModelAndView dash2(@RequestParam(name = "BillDTO", required = false) String billDTO, HttpSession session) {
			ModelAndView mav= new ModelAndView("dashboard");
			if (billDTO != null) {
	            Gson gson = new Gson();
	            BillDTO bDto = gson.fromJson(billDTO, BillDTO.class);
	            mav.addObject("list", bDto.getListResult());
				mav.addObject("list1", bDto.getListResultTwo());
				mav.addObject("list3", bDto.getListResultThree());
	        }
			mav.addObject("username", session.getAttribute("username"));
			return mav;
	}
	@GetMapping("/admin/order")
	public ModelAndView order(HttpSession session) {
		ModelAndView mav = new ModelAndView("order_admin");
		mav.addObject("username", session.getAttribute("username"));
		List<Bill> list0= billMethod.findByStatus(0);
		List<Bill> list1= billMethod.findByStatus(1);
		mav.addObject("list", list0);
		mav.addObject("list1", list1);
		
		return mav;
	}
}
