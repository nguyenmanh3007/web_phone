package com.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.model.User;

public interface UserRepository extends JpaRepository<User, String>{
	boolean existsByUsernameAndPassword(String user,String pass);
	boolean existsByUsername(String un);
	boolean existsByEmail(String email);
	User findByUsername(String user);
	User findByEmail(String user);
}
