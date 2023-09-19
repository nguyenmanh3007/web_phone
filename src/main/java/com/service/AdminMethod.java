package com.service;

import java.util.List;
import com.dto.AdminDTO;
import com.model.Admin;
import com.model.User;

public interface AdminMethod {
	List<AdminDTO> getfindAll();
	boolean checkRoleAdmin(User user);
	
}
