package com.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.model.User;

public interface UserRepository extends JpaRepository<User, String>{
	boolean existsByUsernameAndPass(String user,String pass);
	User findByUsername(String user);
	User findByEmail(String user);
}
