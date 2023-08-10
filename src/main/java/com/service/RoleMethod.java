package com.service;

import java.util.Optional;
import java.util.Set;

import com.model.ERole;
import com.model.Roles;



public interface RoleMethod {
	Optional<Roles> findByRoleName(ERole roleName);
	Set<Roles> getRole(Set<String> strRoles);
}
