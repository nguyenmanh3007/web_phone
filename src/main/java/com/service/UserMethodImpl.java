package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Repository.UserRepository;
import com.converter.DTOconverter;
import com.dto.UserDTO;
import com.model.User;

@Service
public class UserMethodImpl implements UserMethod {
    @Autowired
    private UserRepository use;
    @Autowired
    private DTOconverter converter;
	@Override
	public Iterable<User> findAll() {
		// TODO Auto-generated method stub
		return use.findAll();
	}
	@Override
	public boolean existsByUsernameAndPass(String user, String pass) {
		// TODO Auto-generated method stub
		Iterable<User> list= use.findAll();
		for (User u:list) {
			if(u.getUsername().equals(user) && u.getPass().equals(pass)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public User findByUsername(String user) {
		// TODO Auto-generated method stub
		return use.findByUsername(user);
	}
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		use.save(user);
	}
	@Override
	public List<UserDTO> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		List<UserDTO> users= new ArrayList<>();
		List<User> lu= use.findAll(pageable).getContent();
		for(User u: lu) {
			users.add(converter.toDTO(u));
		}
		return users;
	}
	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return (int) use.count();
	}
	@Override
	public User findByEmail(String user) {
		// TODO Auto-generated method stub
		return use.findByEmail(user);
	}
	@Override
	public boolean checkEmail(String email) {
		Iterable<User> list= use.findAll();
		for (User u:list) {
			if(u.getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}
	
}
