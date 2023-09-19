package com.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
@Table(name="users")
@Getter
@Setter
@Builder
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
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "user",cascade = CascadeType.ALL)
	@JsonIgnore
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<Cart> carts= new HashSet<>();
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "user",cascade = CascadeType.ALL)
	@JsonIgnore
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<Bill> bills=new ArrayList<>();
}
