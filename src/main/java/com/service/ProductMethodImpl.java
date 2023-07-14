package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Repository.ProductRepository;
import com.converter.ProductConverter;
import com.dto.ProductDTO;
import com.model.Product;

@Service
public class ProductMethodImpl implements ProductMethod{
	private JdbcTemplate jdbc;
	@Autowired
	public ProductMethodImpl(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	@Autowired
	private ProductRepository pro;
	@Autowired
	private ProductConverter productConverter;
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return pro.findAll();
	}
	@Override
	public List<Product> findByQuantity(int quan) {
		// TODO Auto-generated method stub
		return pro.findByQuantity(quan);
	}
	private Product mapRowToProduct(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setCode(rs.getString("id"));
		product.setName(rs.getString("name"));
		product.setPrice(rs.getString("price"));
		product.setTag(rs.getString("tag"));
		product.setBe_price(rs.getInt("be_price"));
		product.setDes(rs.getString("des"));
		product.setImg(rs.getString("img"));
		product.setModel(rs.getString("model"));
		product.setConfiguration(rs.getString("configuration"));
		product.setQuantity(rs.getInt("quantity"));
		return product;

	}
	@Override
	public List<Product> getProductByQuantity() {
		// TODO Auto-generated method stub
		return (List<Product>) jdbc.query(" select *from product where quantity>0",this::mapRowToProduct);
	}
	@Override
	@Transactional
	public void delete(Product product) {
		// TODO Auto-generated method stub
		pro.delete(product);
	}
	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		pro.save(product);
	}
	@Override
	@Transactional
	public Product findByCode(String code) {
		// TODO Auto-generated method stub
		return pro.findByCode(code);
	}
	@Override
	public List<Product> findByModel(String mode) {
		// TODO Auto-generated method stub
		return pro.findByModel(mode);
	}
	@Override
	public List<Product> findByConfiguration(String mode) {
		// TODO Auto-generated method stub
		return pro.findByConfiguration(mode);
	}
	@Override
	public List<Product> findByPrice1(int price1, int price2) {
		// TODO Auto-generated method stub
		return (List<Product>) jdbc.query("select * from product where price>? && price<?", this::mapRowToProduct,price1,price2);
	}
	@Override
	public List<Product> findByModelAndConfiguration(String mode,String con) {
		// TODO Auto-generated method stub
		return pro.findByModelAndConfiguration(mode,con);
	}
	@Override
	public List<Product> findByModelAndPrice1(String mode, int price1,int price2) {
		// TODO Auto-generated method stub
		return (List<Product>) jdbc.query("select * from product where model=? and price>? and price <? ", this::mapRowToProduct,mode,price1,price2);
	}
	@Override
	public List<Product> findByConfigurationAndPrice1(String con, int price1, int price2) {
		// TODO Auto-generated method stub
		return (List<Product>) jdbc.query("select * from product where Configuration=? and price>? and price <? ", this::mapRowToProduct,con,price1,price2);
	}
	@Override
	public List<Product> findByModelAndConfigurationAndPrice1(String mode, String con, int price1, int price2) {
		// TODO Auto-generated method stub
		return (List<Product>) jdbc.query("select * from product where model=? and Configuration=? and price>? and price <? ", this::mapRowToProduct,mode,con,price1,price2);
	}
	@Override
	@Transactional
	public ProductDTO create_update(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		Product product= new Product();
		if(pro.findByCode(productDTO.getCode())==null) {
			product=productConverter.toEntity(productDTO);
		}
		else {
			Product oldproduct=pro.findByCode(productDTO.getCode());
			product= productConverter.toEntity(oldproduct, productDTO);
		}
		return productConverter.toDTO(pro.save(product));
	}
	@Override
	@Transactional
	public void deleteByCode(String code) {
		// TODO Auto-generated method stub
		pro.deleteByCode(code);
	}
	@Override
	public List<ProductDTO> findAllProductDTO() {
		// TODO Auto-generated method stub
		List<ProductDTO> lresult= new ArrayList<>();
		List<Product> products= pro.findAll();
		for(Product p: products) {
			if(p.getQuantity()>0) {
				lresult.add(productConverter.toDTO(p));
			}
		}
		return lresult;
	}
	@Override
	public List<ProductDTO> findByQuantityProductDTO(int quan) {
		List<ProductDTO> lresult= new ArrayList<>();
		List<Product> products= pro.findByQuantity(0);
		for(Product p: products) {
			lresult.add(productConverter.toDTO(p));
		}
		return lresult;
	}

}
