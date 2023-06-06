package com.api.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Cart;
import com.service.CartMethod;
import com.service.ProductMethod;


@RestController
public class CartAPI {
	
	@Autowired
	private CartMethod cartMethod;
	
	@Autowired ProductMethod productMethod;
	@DeleteMapping("api/cart")
	public void deleteCart(@RequestBody String ids) {
			String id= ids.substring(1,ids.length()-1);
			Cart cart= cartMethod.findByIdcart(Integer.parseInt(id));
			cartMethod.delete(cart);
	}
	@PostMapping("api/cart")
	public ResponseEntity<?> addToCart(@RequestBody String ids, HttpSession session) {
			String usename= (String) session.getAttribute("user");
			int countcart= cartMethod.findIdCart2();
			int price=Integer.parseInt(productMethod.findByCode(ids.substring(1, ids.length()-1)).getPrice());
			Cart cart= new Cart();
			if(countcart==0) {
				cart.setIdcart(1);
			}
			else {
				int idcar= cartMethod.findIdCart().getIdcart();
				cart.setIdcart(idcar+1);
			}
			cart.setUsername(usename);
			cart.setIdproduct(ids.substring(1, ids.length()-1));
			cart.setNum(1);
			cart.setTotal(price);
			cartMethod.save(cart);
			return ResponseEntity.ok(cart);
	}
	@PostMapping("api/cartNumber")
	public ResponseEntity<?> updateNumCart(@RequestParam(value = "cartId") String cartId, @RequestParam(value = "check") String check, @RequestParam(value = "productId") String idpro
			, HttpSession session){
			String idUpdate=String.valueOf(cartId);
			if(check.equals("plus")) {
				cartMethod.updateNum(idUpdate);
			}
			else {
				cartMethod.updateMNum(idUpdate);
			}
			Cart cart= cartMethod.findByIdcart(Integer.parseInt(cartId));
			int num=cart.getNum();
			int price= Integer.parseInt(productMethod.findByCode(idpro).getPrice());
			int sum=num*price;
			cartMethod.updateTotalCart(idUpdate, sum);
			return ResponseEntity.accepted().body("oke!!");
	}
}
