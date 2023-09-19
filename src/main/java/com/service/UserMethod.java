package com.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.dto.UserDTO;
import com.model.User;

import javax.mail.MessagingException;

public interface UserMethod {

	void sendEmail(String mail, String username, String password) throws MessagingException;

	User findByUsername(String user);

	UserDTO getListUser(int page,int limit);

	void save(User user);

	List<UserDTO> findAll(Pageable pageable);

	int getTotalItem();

	User findByEmail(String user);
	boolean existsByUserName(String un);
	boolean existsByEmail(String email);
}
