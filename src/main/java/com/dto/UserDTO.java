package com.dto;


import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO extends AbstractDTO<UserDTO>{
	private String username;
	private String email;
	private String fname;
	private String lname;
	private String pass;
}
