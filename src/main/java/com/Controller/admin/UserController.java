package com.Controller.admin;

import javax.servlet.http.HttpSession;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.UserDTO;
import com.service.UserMethod;


@Controller(value = "userControllerOfAdmin")
@RequiredArgsConstructor
public class UserController {
	private final UserMethod userMethod;
	@GetMapping("/admin/listCustomer")
	public ModelAndView usf(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpSession session) {
		ModelAndView mav= new ModelAndView("ListUser");
		mav.addObject("username", session.getAttribute("username"));
		UserDTO userDTO = userMethod.getListUser(page,limit);
		mav.addObject("totalPage", userDTO.getTotalPage());
		mav.addObject("page", userDTO.getPage());
		mav.addObject("model", userDTO);
		return mav;
	}
}
