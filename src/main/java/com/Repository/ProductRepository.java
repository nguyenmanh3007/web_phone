package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Product;

public interface ProductRepository extends JpaRepository<Product, String>{
         List<Product> findByQuantity(int quan);
         Product findByCode(String code);
         List<Product> findByModel(String mode);
         List<Product> findByConfiguration(String mode);
         List<Product> findByModelAndConfiguration(String mode, String con);     
         void deleteByCode(String code);
}
