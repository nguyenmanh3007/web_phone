package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dto.cartDTO;
import com.model.Cart;
public interface CartRepository extends JpaRepository<Cart,String>{
	      Cart findByIdproduct(String idpro);
	      Cart findByIdcart(int id);
	      void deleteAllByUsername(String name);
	      
	      
	      @Query(value = "SELECT COUNT(*) FROM cart Where username=?1",nativeQuery = true)
	      int getCountCart(String username);
	  	  @Query(value = "select idbill from bill ORDER BY 1 DESC limit 1",nativeQuery = true)
		  int getIdBill();
	  	  @Query(value = "select * from cart ORDER BY 1 DESC limit 1",nativeQuery = true)
	  	  Cart findIdCart();
	  	  @Query(value = "select COUNT(*) from cart",nativeQuery = true)
	  	  int findIdCart2();
	  	  
	  	  @Query(value = "select cart.idcart as idcart , cart.username as username,  cart.idproduct as idproduct,cart.num as num, product.name as nameproduct, product.price as price , cart.total as total from cart, product where cart.idproduct=product.id and cart.username=:username",nativeQuery = true)
	  	  List<cartDTO> getInfoCartTest(@Param("username") String username);
	      
}
