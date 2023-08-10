package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dto.CartDTO;
import com.model.Cart;
public interface CartRepository extends JpaRepository<Cart,String>{
	      Cart findByIdproduct(String idpro);
	      Cart findByIdcart(int id);
		  @Modifying
	      void deleteAllByUsername(String username);
		  @Query(value = "UPDATE from Product p SET  p.quantity=p.quantity-?1 WHERE p.code=?2")
		  @Modifying
		  void updateQuantityProduct(int sl,String code);
	      @Query(value = "SELECT COUNT(*) FROM cart Where username=?1",nativeQuery = true)
	      int getCountCart(String username);
	  	  @Query(value = "select idbill from bill ORDER BY 1 DESC limit 1",nativeQuery = true)
		  int getIdBill();
	  	  @Query(value = "select * from cart ORDER BY 1 DESC limit 1",nativeQuery = true)
	  	  Cart findIdCart();
	  	  @Query(value = "select COUNT(*) from cart",nativeQuery = true)
	  	  int findNumberCart();
		  @Query(value = "update from Cart c set c.num=c.num+1 where c.idcart=?1")
		  @Modifying
	  	  void updateNumberCart(int idCart);
		  @Query(value = "update from Cart c set c.num=c.num-1 where c.idcart=?1")
		  @Modifying
		  void updateMNumberCart(int idCart);
	      @Query(value = "update from Cart c set c.total=?1 where c.idcart=?2")
		  @Modifying
		  void updateTotalCart(int sum, int sl);
		  @Query(value = "SELECT sum(c.total) from Cart c where c.username=?1")
		  Integer getTotalCartByUsername(String username);
	  	  @Query(value = "select cart.idcart as idcart , cart.username as username,  cart.idproduct as idproduct,cart.num as num, product.name as nameproduct, product.price as price , cart.total as total from cart, product " +
				  "where cart.idproduct=product.id and cart.username=:username",nativeQuery = true)
	  	  List<CartDTO> getInfoCartTest(@Param("username") String username);
	      
}
