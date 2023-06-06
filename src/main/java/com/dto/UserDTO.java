package com.dto;


public class UserDTO extends AbstractDTO<UserDTO>{
	private String username;
	private String email;
	private String fname;
	private String lname;
	private String pass;
	private String passencode;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPassencode() {
		return passencode;
	}
	public void setPassencode(String passencode) {
		this.passencode = passencode;
	}
	
	
}
