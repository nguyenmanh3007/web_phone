package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.Repository.CartRepository;
import com.dto.cartDTO;
import com.model.Cart;

@Service
public class CartMethodImpl implements CartMethod {
	private JdbcTemplate jdbc;

	@Autowired
	public CartMethodImpl(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Autowired
	private CartRepository cartRepository;

	@Override
	public Iterable<Cart> findAll() {
		return cartRepository.findAll();
	}

	@Override
	public void save(Cart cart) {
		// TODO Auto-generated method stub
		cartRepository.save(cart);
	}

	@Override
	public void delete(Cart cart) {
		// TODO Auto-generated method stub
		cartRepository.delete(cart);
	}

	@Override
	public Cart findByIdproduct(String idpro) {
		return cartRepository.findByIdproduct(idpro);
	}

	@Override
	public Cart findIdCart() {
		// TODO Auto-generated method stub
		return cartRepository.findIdCart();
	}

	@Override
	public int findIdCart2() {
		return cartRepository.findIdCart2();
	}
	@Override
	public List<cartDTO> getInfoCart(String username) {
		// TODO Auto-generated method stub
		return cartRepository.getInfoCartTest(username);
	}
	
	@Override
	public int getCountCart(String username) {
		return cartRepository.getCountCart(username);
	}

	@Override
	public Cart findByIdcart(int id) {
		return cartRepository.findByIdcart(id);
	}

	@Override
	public void updateNum(String id) {
		jdbc.update("update cart set num=num+1 where idcart=?", id);
	}

	@Override
	public void updateMNum(String id) {
		jdbc.update("update cart set num=num-1 where idcart=?", id);
	}

	@Override
	public void updateTotalCart(String id, int sum) {
		jdbc.update("update cart set total=? where idcart=?", sum, id);
	}

	@Override
	public void deleteAllByUsername(String username) {

		jdbc.update("delete from cart where username=?", username);
	}

	@Override
	public int getIdBill() {
		return cartRepository.getIdBill();
	}

	@Override
	public void udProduct(String name, int sl) {
		jdbc.update("UPDATE product SET  quantity=quantity-? WHERE id=?", sl, name);

	}
}
