package com.service;

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

	@Override
	public List<Bill> getBillByDate(String day1, String day2) {
		return billRepository.getBillByDate(day1, day2);
	}
	@Override
	@Transactional
	public BillDTO create(BillDTO billDTO) {
		Bill bill= new Bill();
		bill= billConverter.toEntity(billDTO);
		return billConverter.toDto(billRepository.save(bill));
	}

	@Override
	public List<Bill> getBillByUser(String username) {
		return billRepository.getBillByUser(username);
	}

	@Override
	public int deleteBillById(int id) {
		return jdbc.update("DELETE FROM bill WHERE idbill = ?",id);
	}

	@Override
	public List<Bill> findByStatus(int stt) {
		List<Bill> list=billRepository.findByStatus(stt);
		return list;
	}

	@Override
	public List<Bill> findByDateAndStatus(String day1, int stt) {
		return billRepository.findByDateAndStatus(day1, stt);
	}

	@Override
	public void update_order(int ids) {
		jdbc.update("update bill set status=status+1 where idbill=?", ids);
	}

	
}
