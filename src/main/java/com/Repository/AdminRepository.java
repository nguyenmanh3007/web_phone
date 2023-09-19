package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Admin;
import org.springframework.security.core.parameters.P;

public interface AdminRepository extends JpaRepository<Admin, String>{
}
