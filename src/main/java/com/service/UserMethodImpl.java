package com.service;

import java.util.List;
import java.util.stream.Collectors;

import com.converter.UserConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.Repository.UserRepository;
import com.dto.UserDTO;
import com.model.User;

@Service
@RequiredArgsConstructor
public class UserMethodImpl implements UserMethod {
    private final UserRepository userRepository;
    private final UserConverter userConverter;
	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}
	@Override
	public boolean existsByUsernameAndPass(String user, String pass) {
		Iterable<User> list= userRepository.findAll();
		for (User u:list) {
			if(u.getUsername().equals(user) && u.getPassword().equals(pass)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public User findByUsername(String user) {
		return userRepository.findByUsername(user);
	}

	@Override
	public UserDTO getListUser(int page, int limit) {
		UserDTO userDTO = new UserDTO();
		userDTO.setPage(page);
		Pageable pageable= PageRequest.of(page-1, limit);
		userDTO.setListResult(findAll(pageable));
		userDTO.setTotalPage((int) Math.ceil((double)(getTotalItem()) / limit));
		return userDTO;
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}
	@Override
	public List<UserDTO> findAll(Pageable pageable) {
		List<User> lUser= userRepository.findAll(pageable).getContent();
		return lUser.stream().map(user -> userConverter.toDTO(user)).collect(Collectors.toList());
	}
	@Override
	public int getTotalItem() {
		return (int) userRepository.count();
	}
	@Override
	public User findByEmail(String user) {
		return userRepository.findByEmail(user);
	}
	@Override
	public boolean checkEmail(String email) {
		Iterable<User> list= userRepository.findAll();
		for (User u:list) {
			if(u.getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean existsByUserName(String un) {
		return userRepository.existsByUsername(un);
	}
	@Override
	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}
	
}
