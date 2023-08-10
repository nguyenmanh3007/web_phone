package com.api.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.AdminDTO;
import com.service.AdminMethod;

@RestController
@RequiredArgsConstructor
public class AdminAPI {
	private final AdminMethod adminMethod;
	@GetMapping("/api/admin")
	public AdminDTO getAllAdmin(){
		AdminDTO adminDTO= new AdminDTO();
		adminDTO.setListResult(adminMethod.getfindAll());
		return adminDTO;
	}
}
