package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.model.Product;

public interface ProductRepository extends JpaRepository<Product, String>{
         List<Product> findByQuantity(int quan);
         Product findByCode(String code);
         List<Product> findByModel(String mode);
         List<Product> findByConfiguration(String mode);
         List<Product> findByModelAndConfiguration(String mode, String con);     
         void deleteByCode(String code);
         
         @Query(value = "select *from product where quantity>0",nativeQuery = true)
         List<Product> getProductByQuantity();
         
         @Query(value = "select * from product where price>?1 && price<?2",nativeQuery = true)
         List<Product> findByPrice1(int price1, int price2);
         
         @Query(value = "select * from product where model=?1 and price>?2 and price <?3",nativeQuery = true)
         List<Product> findByModelAndPrice(String mode, int price1,int price2);
         
         @Query(value = "select * from product where Configuration=?1 and price>?2 and price <?3",nativeQuery = true)
         List<Product> findByConfigurationAndPrice(String con, int price1, int price2);
         
         @Query(value = "select * from product where model=?1 and Configuration=?2 and price>?3 and price <?4",nativeQuery = true)
         List<Product> findByModelAndConfigurationAndPrice(String mode, String con, int price1, int price2);
}
