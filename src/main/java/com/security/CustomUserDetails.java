package com.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomUserDetails implements UserDetails {
	private static final long serialVersionUID = 1L;
	private int userId;
	private String username;
	@JsonIgnore
	private String password;
	private String email;
	private String fname;
	private String lname;
	private Collection<? extends GrantedAuthority> authorities;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.authorities;
	}
	public static CustomUserDetails mapUserToUserDetail(User users) {
		// Lay cac quyen tu doi tuong user
		List<GrantedAuthority> listAuthorities= users.getListRoles().stream()
				.map(roles -> new SimpleGrantedAuthority(roles.getRoleName().name()))
				.collect(Collectors.toList());
		return new CustomUserDetails(
					users.getUserId(),
					users.getUsername(),
					users.getPassword(),
					users.getEmail(),
					users.getLname(),
					users.getFname(),
					listAuthorities
				);
				
	}
	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
