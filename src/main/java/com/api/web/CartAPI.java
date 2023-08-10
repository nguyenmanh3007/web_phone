package com.api.web;

import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class CartAPI {
	private final CartMethod cartMethod;
	private final ProductMethod productMethod;
	@DeleteMapping("api/cart")
	public void deleteCart(@RequestBody String ids) {
			String id= ids.substring(1,ids.length()-1);
			Cart cart= cartMethod.findByIdcart(Integer.parseInt(id));
			cartMethod.delete(cart);
	}
	@PostMapping("api/cart")
	public ResponseEntity<?> addToCart(@RequestBody String ids, HttpSession session) {
			cartMethod.addToCart(ids, (String) session.getAttribute("user"));
			return ResponseEntity.ok("add to cart successful");
	}
	@PostMapping("api/cartNumber")
	public ResponseEntity<?> updateNumCart(@RequestParam(value = "cartId") int cartId,
										   @RequestParam(value = "check") String check,
										   @RequestParam(value = "productId") String idProduct){
			cartMethod.updateNumberProductFromCart(cartId,check,idProduct);
			return ResponseEntity.ok("update number product successful");
	}
}
