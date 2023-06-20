package com.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dto.UserDTO;
import com.model.User;

public interface UserMethod {
	Iterable<User> findAll();

	boolean existsByUsernameAndPass(String user, String pass);

	User findByUsername(String user);

	void save(User user);

	List<UserDTO> findAll(Pageable pageable);

	int getTotalItem();

	User findByEmail(String user);
	boolean checkEmail(String email);
}
