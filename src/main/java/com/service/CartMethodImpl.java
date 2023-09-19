package com.service;

import java.util.List;

import com.Repository.ProductRepository;
import com.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Repository.CartRepository;
import com.dto.CartDTO;
import com.model.Cart;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CartMethodImpl implements CartMethod {
	private final CartRepository cartRepository;
	private final ProductRepository productRepository;
	private final UserRepository userRepository;

	@Override
	public Iterable<Cart> findAll() {
		return cartRepository.findAll();
	}

	@Override
	public void save(Cart cart) {
		cartRepository.save(cart);
	}

	@Override
	public void delete(Cart cart) {
		cartRepository.delete(cart);
	}

	@Override
	public Cart findByIdproduct(String idpro) {
		return cartRepository.findByProduct_Code(idpro);
	}

	@Override
	public Cart findIdCart() {
		return cartRepository.findIdCart();
	}

	@Override
	public int findNumberCart() {
		return cartRepository.findNumberCart();
	}

	@Override
	public void addToCart(String idP, String username) {
		int countCart= findNumberCart();
		int price=Integer.parseInt(productRepository.findByCode(idP.substring(1, idP.length()-1)).getPrice());
		Cart cart= new Cart();
		if(countCart==0) {
			cart.setIdCart(1);
		}
		else {
			int idCar= findIdCart().getIdCart();
			cart.setIdCart(idCar+1);
		}
		cart.setUser(userRepository.findByUsername(username));
		cart.setProduct(productRepository.findByCode(idP.substring(1, idP.length()-1)));
		cart.setNum(1);
		cart.setTotal(price);
		save(cart);
	}

	@Override
	@Transactional
	public void updateNumberProductFromCart(int cartId, String checkStatus, String productId) {
		if(checkStatus.equals("plus")) {
			updateNumberCart(cartId);
		}
		else {
			updateMNumberCart(cartId);
		}
		Cart cart= findByIdcart(cartId);
		int num=cart.getNum();
		int price= Integer.parseInt(productRepository.findByCode(productId).getPrice());
		int sum=num*price;
		updateTotalCart(cartId, sum);
	}

	@Override
	public List<CartDTO> getInfoCart(String username) {
		return cartRepository.getInfoCartTest(username);
	}
	
	@Override
	public int getCountCart(String username) {
		return cartRepository.getCountCart(username);
	}

	@Override
	public Cart findByIdcart(int id) {
		return cartRepository.findByIdCart(id);
	}

	@Override
	public Integer getTotalCartByUsername(String username) {
		return cartRepository.getTotalCartByUsername(username);
	}

	@Override
	@Transactional
	public void updateNumberCart(int id) {
		cartRepository.updateNumberCart(id);
	}

	@Override
	@Transactional
	public void updateMNumberCart(int id) {
		cartRepository.updateMNumberCart(id);
	}

	@Override
	@Transactional
	public void updateTotalCart(int id, int sum) {
		cartRepository.updateTotalCart(sum,id);
	}

	@Override
	@Transactional
	public void deleteAllByUser(String username) {
		cartRepository.deleteAllByUser(username);
	}

	@Override
	public int getIdBill() {
		return cartRepository.getIdBill();
	}

	@Override
	@Transactional
	public void updateQuantityProduct(String code, int sl) {
		cartRepository.updateQuantityProduct(sl, code);
	}
}
