package com.service;

import java.util.Optional;
import java.util.Set;

import com.model.ERole;
import com.model.Roles;



public interface RoleMethod {
	Set<Roles> getRole(Set<String> strRoles);
}
