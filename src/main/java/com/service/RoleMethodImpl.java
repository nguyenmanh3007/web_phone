package com.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.Repository.RoleRepository;
import com.model.ERole;
import com.model.Roles;


@Service
@RequiredArgsConstructor
public class RoleMethodImpl implements RoleMethod {
	private final RoleRepository roleRepository;
	@Override
	public Optional<Roles> findByRoleName(ERole roleName) {
		return roleRepository.findByRoleName(roleName);
	}

	@Override
	public Set<Roles> getRole(Set<String> strRoles) {
		Set<Roles> listRoles = new HashSet<>();
		if (strRoles == null) {
			Roles userRole = roleRepository.findByRoleName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Employee role is not found"));
			listRoles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
					case "admin":
						Roles adminRole = roleRepository.findByRoleName(ERole.ROLE_ADMIN)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found"));
						listRoles.add(adminRole);
						break;
					case "user":
						Roles modRole = roleRepository.findByRoleName(ERole.ROLE_USER)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found"));
						listRoles.add(modRole);
						break;
				}
			});
		}
		return listRoles;
	}

}
