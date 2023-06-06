package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.Repository.CartRepository;
import com.model.Cart;
import com.model.Carts;

import com.model.Bill;


@Service
public class CartMethodImpl implements CartMethod{
	private JdbcTemplate jdbc;
	@Autowired
	public CartMethodImpl (JdbcTemplate jdbc) {
		this.jdbc=jdbc;
	}
	@Autowired
	private CartRepository car;
	@Override
	public Iterable<Cart> findAll() {
		// TODO Auto-generated method stub
		return car.findAll();
	}

	@Override
	public void save(Cart cart) {
		// TODO Auto-generated method stub
		car.save(cart);
	}

	@Override
	public void delete(Cart cart) {
		// TODO Auto-generated method stub
		car.delete(cart);
	}

	@Override
	public Cart findByIdproduct(String idpro) {
		// TODO Auto-generated method stub
		return car.findByIdproduct(idpro);
	}
	private Cart mapRowToCart(ResultSet rs, int rowNum) throws SQLException {
		Cart cart = new Cart();
		cart.setIdcart(rs.getInt("idcart"));
		return cart;
	}
	@Override
	public Cart findIdCart() {
		// TODO Auto-generated method stub
		return (Cart) jdbc.queryForObject("select idcart from cart ORDER BY 1 DESC limit 1", this::mapRowToCart);
	} 
	@Override
	public int findIdCart2() {
		// TODO Auto-generated method stub
		return (int) jdbc.queryForObject("select COUNT(*) from cart", this::mapRowToCountCart2);
	}
	private int mapRowToCountCart2(ResultSet rs, int rowNum) throws SQLException {
		return rs.getInt("COUNT(*)");
	}

	@Override
	public List<Carts> getInfoCart(String username) {
		return (List<Carts>) jdbc.query(
                "select cart.idcart, cart.idproduct, cart.username, cart.num, cart.total, product.name, product.price from cart, product where cart.idproduct=product.id and cart.username=?",
				this::mapRowToCarts, username);
	}
	private Carts mapRowToCarts(ResultSet rs, int rowNum) throws SQLException {
		Carts carts = new Carts();
		carts.setIdcart(rs.getInt("idcart"));
		carts.setPrice(rs.getInt("price"));
		carts.setNum(rs.getInt("num"));
		carts.setTotal(rs.getInt("total"));
		carts.setUsername(rs.getString("username"));
		carts.setIdproduct(rs.getString("idproduct"));
		carts.setNameproduct(rs.getString("name"));
		return carts;
	}
	@Override
	public int getCountCart(String username) {
		return (int) jdbc.queryForObject("SELECT COUNT(*) FROM cart Where username=?", this::mapRowToCountCart, username);		
		 
	}
	private int mapRowToCountCart(ResultSet rs, int rowNum) throws SQLException {
		return rs.getInt("COUNT(*)");
	}

	@Override
	public Cart findByIdcart(int id) {
		// TODO Auto-generated method stub
		return car.findByIdcart(id);
	}
	@Override
	public void updateNum(String id) {
		// TODO Auto-generated method stub
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
	public Bill getIdBill() {
		return (Bill) jdbc.queryForObject("select idbill from bill ORDER BY 1 DESC limit 1", this::mapRowToIdBill);
	}
	private Bill mapRowToIdBill(ResultSet rs, int rowNum) throws SQLException {
		Bill bill = new Bill();
		bill.setIdbill(rs.getInt("idbill"));
		return bill;
	}
	@Override
	public void udProduct(String name, int sl) {
		jdbc.update("UPDATE product SET  quantity=quantity-? WHERE id=?", sl,name);
		
	}
}
