package com.Controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.AdminDTO;
import com.dto.BillDTO;
import com.google.gson.Gson;
import com.model.Admin;

@Controller(value = "adminControllerOfAdmin")
public class AdminController {
	@GetMapping("/adminLogin")
	public ModelAndView lga() {
		ModelAndView mav= new ModelAndView("AdminLogin");
		mav.addObject("admin", new Admin());
		return mav;
	}
	@GetMapping("adminForm")
	public ModelAndView dashboard(@RequestParam(name = "BillDTO", required = false) String billDTO,HttpServletRequest request, HttpSession session) {
		ModelAndView mavOne= new ModelAndView("dashboard");
		ModelAndView mavTwo= new ModelAndView("AdminLogin");
		if(request.getParameter("message").equalsIgnoreCase("success")) {
			if (billDTO != null) {
		        Gson gson = new Gson();
		        BillDTO bDto = gson.fromJson(billDTO, BillDTO.class);
		        mavOne.addObject("list", bDto.getListResult());
				mavOne.addObject("list1", bDto.getListResultTwo());
				mavOne.addObject("list3", bDto.getListResultThree());
				session.setAttribute("admin", bDto.getUsername());
		    }
			mavOne.addObject("username", session.getAttribute("admin"));
			return mavOne;
		}
		else {
			mavTwo.addObject("message", "Username or password invalid!!!");
			mavTwo.addObject("admin", new Admin());
			return mavTwo;
		}
	}
	@GetMapping("/adminForm1")
	public ModelAndView stat(@RequestParam(name = "AdminDTO", required = false) String adminDto,HttpSession session) {
		ModelAndView mav= new ModelAndView("listAdmin");
		mav.addObject("username", session.getAttribute("admin"));
		if (adminDto != null) {
            Gson gson = new Gson();
            AdminDTO adminDTO = gson.fromJson(adminDto, AdminDTO.class);
            mav.addObject("list", adminDTO.getListResult());
        }
		return mav;
	}
}
