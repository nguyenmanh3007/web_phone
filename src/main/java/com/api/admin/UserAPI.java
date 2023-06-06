package com.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dto.UserDTO;
import com.service.UserMethod;

@RestController
public class UserAPI {
	@Autowired
	private UserMethod userMethod;
	@GetMapping("/api/user")
	public UserDTO showUser(@RequestParam("page") int page, @RequestParam("limit") int limit){
		UserDTO userDTO = new UserDTO();
		userDTO.setPage(page);
		Pageable pageable= PageRequest.of(page-1, limit);
		userDTO.setListResult(userMethod.findAll(pageable));
		userDTO.setTotalPage((int) Math.ceil((double)(userMethod.getTotalItem()) / limit));
		return userDTO;
	}
}
