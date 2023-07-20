package com.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.model.Bill;

public interface BillRepository extends JpaRepository<Bill, String>{
	List<Bill> findByDate(String day1);
	List<Bill> findByStatus(int stt);
	List<Bill> findByDateAndStatus(String day1,int stt);
	
	@Query(value ="SELECT * FROM bill where username=?1 order by 1 desc",nativeQuery = true)
	List<Bill> getBillByUser(String username);
	
	@Query(value = "select * from bill where date BETWEEN ?1 AND ?2", nativeQuery = true)
	List<Bill> getBillByDate(String day1, String day2);
	
}
