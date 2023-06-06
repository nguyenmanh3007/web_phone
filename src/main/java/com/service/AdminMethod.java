package com.service;

import java.util.List;

import com.dto.AdminDTO;
import com.model.Admin;

public interface AdminMethod {
	Iterable<Admin> findAll();
	boolean existsByUsernameAndPassword(String user,String pass);
	List<AdminDTO> getfindAll();
	
}
