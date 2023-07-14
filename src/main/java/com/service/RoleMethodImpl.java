package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Repository.RoleRepository;
import com.model.ERole;
import com.model.Roles;


@Service
public class RoleMethodImpl implements RoleMethod {

	@Autowired
	private RoleRepository roleRepository;
	@Override
	public Optional<Roles> findByRoleName(ERole roleName) {
		// TODO Auto-generated method stub
		return roleRepository.findByRoleName(roleName);
	}

}
