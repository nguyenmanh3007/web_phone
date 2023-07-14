package com.service;

import java.util.Optional;

import com.model.ERole;
import com.model.Roles;



public interface RoleMethod {
	Optional<Roles> findByRoleName(ERole roleName);
}
