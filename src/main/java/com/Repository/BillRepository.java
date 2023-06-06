package com.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Bill;

public interface BillRepository extends JpaRepository<Bill, String>{
	List<Bill> findByDate(String day1);
	List<Bill> findByStatus(int stt);
	List<Bill> findByDateAndStatus(String day1,int stt);
}
