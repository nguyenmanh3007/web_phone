package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Cart;

public interface CartRepository extends JpaRepository<Cart,String>{
	      Cart findByIdproduct(String idpro);
	      Cart findByIdcart(int id);
	      void deleteAllByUsername(String name);
	      
}
