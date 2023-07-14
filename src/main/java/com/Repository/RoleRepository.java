package com.Repository;

import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;

import com.model.ERole;
import com.model.Roles;


public interface RoleRepository extends JpaRepository<Roles, Integer>{
	Optional<Roles> findByRoleName(ERole roleName);
}
