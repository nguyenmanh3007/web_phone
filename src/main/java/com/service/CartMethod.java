package com.service;

import java.util.List;

import com.dto.cartDTO;
import com.model.Cart;

public interface CartMethod {
		Iterable<Cart> findAll();
		void save(Cart cart);
		void delete(Cart cart);
		Cart findByIdproduct(String idpro);
		Cart findIdCart();
		List<cartDTO> getInfoCart(String username);
		int getCountCart(String username);
		Cart findByIdcart(int id);
		void updateNum(String id);
		void updateMNum(String id);
		void updateTotalCart(String id, int sum);
		void deleteAllByUsername(String name);
		int getIdBill();
		void udProduct(String name, int sl);
		int findIdCart2();
		
}
