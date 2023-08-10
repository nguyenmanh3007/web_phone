package com.service;

import java.util.List;
import java.util.stream.Collectors;

import com.converter.AdminConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.Repository.AdminRepository;
import com.dto.AdminDTO;
import com.model.Admin;
import com.model.Roles;
import com.model.User;
@Service
@RequiredArgsConstructor
public class AdminMethodImpl implements AdminMethod{
	private final AdminRepository adminRepository;
	private final AdminConverter adminConverter;
	@Override
	public boolean existsByUsernameAndPassword(String user, String pass) {
		Iterable<Admin> list=adminRepository.findAll();
		for(Admin a:list) {
			if(a.getUsername().equals(user) && a.getPassword().equals(pass)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public Iterable<Admin> findAll() {
		return adminRepository.findAll();
	}
	@Override
	public List<AdminDTO> getfindAll() {
		List<Admin> list = adminRepository.findAll();
		return list.stream().map(admin -> adminConverter.toDTO(admin)).collect(Collectors.toList());
	}
	@Override
	public boolean checkRoleAdmin(User user) {
		for(Roles role: user.getListRoles()) {
			if(role.getRoleId()==2) {
				return true;
			}
		}
		return false;
	}

}
