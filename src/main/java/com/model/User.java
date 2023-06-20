package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userss")
public class User {
	@Id
	@Column(name="user_name", nullable=false)
	private String username;
	@Column(name="email", nullable=false)
	private String email;
	@Column(name="f_name", nullable=false)
	private String fname;
	@Column(name="l_name", nullable=false)
	private String lname;
	@Column(name="pass", nullable=false)
	private String pass;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String email, String fname, String lname, String pass) {
		super();
		this.username = username;
		this.email = email;
		this.fname = fname;
		this.lname = lname;
		this.pass = pass;
	}
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
	
}
