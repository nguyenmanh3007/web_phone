	package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Repository.BillRepository;
import com.converter.BillConverter;
import com.dto.BillDTO;
import com.model.Bill;
@Repository
@Service
public class BillMethodImpl implements BillMethod {
	private JdbcTemplate jdbc;
	@Autowired
	public BillMethodImpl(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	@Autowired
	private BillRepository billRepository;
	@Autowired
	private BillConverter billConverter;
	@Override
	public Iterable<Bill> findAll() {
		// TODO Auto-generated method stub
		return billRepository.findAll();
	}

	@Override
	public void save(Bill bill) {
		// TODO Auto-generated method stub
		billRepository.save(bill);
	}

	@Override
	public void delete(Bill bill) {
		// TODO Auto-generated method stub
		billRepository.delete(bill);
	}

	@Override
	public List<Bill> findByDate(String day1) {
		// TODO Auto-generated method stub
		return billRepository.findByDate(day1);
	}
	private Bill mapRowToBill(ResultSet rs, int rowNum) throws SQLException {
		Bill bill = new Bill();
		bill.setIdbill(rs.getInt("idbill"));
		bill.setCountry(rs.getString("country"));
		bill.setCity(rs.getString("city"));
		bill.setCounty(rs.getString("county"));
		bill.setHn(rs.getString("hn"));
		bill.setPhone(rs.getString("phone"));
		bill.setDate(rs.getString("date"));
		bill.setTotal(rs.getInt("total"));
		bill.setUsername(rs.getString("username"));
		bill.setProducts(rs.getString("products"));
		bill.setStatus(rs.getInt("status"));
		return bill;

	}
	@Override
	public List<Bill> getBillByDate(String day1, String day2) {
		return (List<Bill>) jdbc.query("select idbill, country, city, county, hn, phone, date, total, username, products,status from bill where date BETWEEN ? AND ?",
				this::mapRowToBill, day1, day2);
		
	}
	@Override
	@Transactional
	public BillDTO create(BillDTO billDTO) {
		// TODO Auto-generated method stub
		Bill bill= new Bill();
		bill= billConverter.toEntity(billDTO);
		return billConverter.toDto(billRepository.save(bill));
	}

	@Override
	public List<Bill> getBillByUser(String username) {
		// TODO Auto-generated method stub
		return (List<Bill>) jdbc.query("select idbill, country, city, county, hn, phone, date, total, username, products,status from bill where username=? ORDER BY 1 DESC",
				this::mapRowToBill, username);
	}

	@Override
	public int deleteBillById(int id) {
		// TODO Auto-generated method stub
		return jdbc.update("DELETE FROM bill WHERE idbill = ?",id);
	}

	@Override
	public List<Bill> findByStatus(int stt) {
		// TODO Auto-generated method stub
		List<Bill> list=billRepository.findByStatus(stt);
		return list;
	}

	@Override
	public List<Bill> findByDateAndStatus(String day1, int stt) {
		// TODO Auto-generated method stub
		return billRepository.findByDateAndStatus(day1, stt);
	}

	@Override
	public void update_order(int ids) {
		jdbc.update("update bill set status=status+1 where idbill=?", ids);
	}

	
}
