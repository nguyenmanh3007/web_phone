package com.service;


import java.util.List;

import com.dto.BillDTO;
import com.model.Bill;

public interface BillMethod {
		Iterable<Bill> findAll();
		void save(Bill bill);
		void delete(Bill bill);
		List<Bill> findByDate(String ngay);
		BillDTO create(BillDTO billDTO);
		List<Bill> getBillByDate(String day1, String day2);
		List<Bill> getBillByUser(String username);
		int deleteBillById(int id);
		List<Bill> findByStatus(int stt);
		List<Bill> findByDateAndStatus(String day1,int stt);
		void update_order(int ids);
}
