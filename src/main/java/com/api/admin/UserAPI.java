package com.api.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dto.UserDTO;
import com.service.UserMethod;

@RestController
@RequiredArgsConstructor
public class UserAPI {
	private final UserMethod userMethod;
	@GetMapping("/api/user")
	public UserDTO getAllUser(@RequestParam("page") int page, @RequestParam("limit") int limit){
		return userMethod.getListUser(page,limit);
	}
}
