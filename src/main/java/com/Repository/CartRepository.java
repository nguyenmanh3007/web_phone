package com.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dto.CartDTO;
import com.model.Cart;
public interface CartRepository extends JpaRepository<Cart,String>{
	      Cart findByProduct_Code(String idpro);
	      Cart findByIdCart(int id);
		  @Query("DELETE FROM Cart c WHERE c.user IN (SELECT u FROM User u WHERE u.username = ?1)")
		  @Modifying
	      void deleteAllByUser(String username);
		  @Query(value = "UPDATE FROM Product p SET  p.quantity=p.quantity-?1 WHERE p.code=?2")
		  @Modifying
		  void updateQuantityProduct(int sl,String code);
	      @Query(value = "SELECT COUNT(c) FROM Cart c Where c.user.username=?1")
	      int getCountCart(String username);
	  	  @Query(value = "SELECT b.idbill FROM bill b ORDER BY b.idbill DESC limit 1",nativeQuery = true)
		  int getIdBill();
			@Query(value = "SELECT * FROM cart c ORDER BY 1 DESC LIMIT 1",nativeQuery = true)
	  	  Cart findIdCart();
	  	  @Query(value = "select COUNT(*) from Cart")
	  	  int findNumberCart();
		  @Query(value = "update from Cart c set c.num=c.num+1 where c.idCart=?1")
		  @Modifying
	  	  void updateNumberCart(int idCart);
		  @Query(value = "update from Cart c set c.num=c.num-1 where c.idCart=?1")
		  @Modifying
		  void updateMNumberCart(int idCart);
	      @Query(value = "update from Cart c set c.total=?1 where c.idCart=?2")
		  @Modifying
		  void updateTotalCart(int sum, int sl);
		  @Query(value = "SELECT sum(c.total) from Cart c where c.user.username=?1")
		  Integer getTotalCartByUsername(String username);
	  	  @Query(value = "select c.idCart as idcart , c.user.username as username,  c.product.code as idproduct,c.num as num, p.name as nameproduct, p.price as price , c.total as total from Cart c, Product p " +
				  "where c.product.code = p.code and c.user.username=:username")
	  	  List<CartDTO> getInfoCartTest(@Param("username") String username);
	      
}
