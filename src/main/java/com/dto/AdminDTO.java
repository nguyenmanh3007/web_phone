package com.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AdminDTO extends AbstractDTO<AdminDTO>{
	private int id;
	private String username;
	private String password;
	private String fullname;
	private String email;
	private String phone;


}
