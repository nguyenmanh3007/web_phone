package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.model.User;


@Service
public class CustomerUserDetailService implements UserDetailsService {
	@Autowired
	private UserMethod userMethod;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		if(userMethod.checkEmail(username)) {
		    User user= userMethod.findByEmail(username);
		    List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		    GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
		    grantList.add(authority);
			UserDetails userDetails= new org.springframework.security.core.userdetails.User(username,user.getPass(),grantList);
			return userDetails;
		}
		else {
			new UsernameNotFoundException("login fail");
		}
		return null;
	}

}
