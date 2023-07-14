package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="userss")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="UserId")
	private int userId;
	@Column(name="username", nullable=false,unique = true)
	private String username;
	@Column(name="email", nullable=false,unique = true)
	private String email;
	@Column(name="f_name", nullable=false)
	private String fname;
	@Column(name="l_name", nullable=false)
	private String lname;
	@Column(name="password", nullable=false)
	private String password;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="User_Role",joinColumns = @JoinColumn(name="UserId"),inverseJoinColumns = @JoinColumn(name="RoleId"))
	private Set<Roles> listRoles = new HashSet<>();
}
