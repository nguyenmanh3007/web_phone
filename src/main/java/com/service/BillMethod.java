package com.service;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.dto.BillDTO;
import com.model.Bill;

public interface BillMethod {
		Iterable<Bill> findAll();
		void save(Bill bill);
		void delete(Bill bill);
		List<Bill> findByDate(String ngay);

		Map<String,List<BillDTO>> getAllBill();
		BillDTO create(BillDTO billDTO,String name);
		List<Bill> getBillByUser(String username);
		void deleteBillById(int id);
		List<Bill> findByStatus(int stt);
		List<Bill> findByDateAndStatus(String day1,int stt);
		void updateOrder(int ids);
}
