package com.payload.request;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {
	private String userName;
	private String password;
	private String email;
	private String fname;
	private String lname;
	private Set<String> listRoles;
	
}
