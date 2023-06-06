package com.converter;

import org.springframework.stereotype.Component;

import com.dto.AdminDTO;
import com.dto.UserDTO;
import com.model.Admin;
import com.model.User;

@Component
public class DTOconverter {
	public UserDTO toDTO(User user) {
		UserDTO users= new UserDTO();
		users.setUsername(user.getUsername());
		users.setEmail(user.getEmail());
		users.setFname(user.getFname());
		users.setLname(user.getLname());
		users.setPass(user.getPass());
		users.setPassencode(user.getPassencode());
		return users;
		
	}
	public AdminDTO toDTO(Admin admin) {
		AdminDTO adminDTO= new AdminDTO();
		adminDTO.setUsername(admin.getUsername());
		adminDTO.setPassword(admin.getPassword());
		
		return adminDTO;
	}
}
