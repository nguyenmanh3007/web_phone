package com.service;

import java.util.List;

import com.dto.CartDTO;
import com.model.Cart;

public interface CartMethod {
		Iterable<Cart> findAll();
		void save(Cart cart);
		void delete(Cart cart);
		Cart findByIdproduct(String idpro);
		Cart findIdCart();
		List<CartDTO> getInfoCart(String username);
		int getCountCart(String username);
		Cart findByIdcart(int id);

		Integer getTotalCartByUsername(String username);
		void updateNumberCart(int id);
		void updateMNumberCart(int id);
		void updateTotalCart(int id, int sum);
		void deleteAllByUser(String username);
		int getIdBill();
		void updateQuantityProduct(String name, int sl);
		int findNumberCart();
		void addToCart(String idP,String username);

		void updateNumberProductFromCart(int cartId, String checkStatus,String productId);
		
}
