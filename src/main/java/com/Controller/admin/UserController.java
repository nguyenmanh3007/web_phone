package com.Controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dto.UserDTO;
import com.service.UserMethod;


@Controller(value = "userControllerOfAdmin")
public class UserController {
	@Autowired
	private UserMethod userMethod;
	@GetMapping("/userAdminForm")
	public ModelAndView usf(@RequestParam("page") int page, @RequestParam("limit") int limit, HttpSession session) {
		ModelAndView mav= new ModelAndView("ListUser");
		mav.addObject("username", session.getAttribute("admin"));
		UserDTO userDTO = new UserDTO();
		userDTO.setPage(page);
		Pageable pageable= PageRequest.of(page-1, limit);
		userDTO.setListResult(userMethod.findAll(pageable));
		userDTO.setTotalPage((int) Math.ceil((double)(userMethod.getTotalItem()) / limit));
		mav.addObject("totalPage", userDTO.getTotalPage());
		mav.addObject("page", userDTO.getPage());
		mav.addObject("model", userDTO);
		return mav;
	}
}
