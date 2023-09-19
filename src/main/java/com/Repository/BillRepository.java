package com.Repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.model.Bill;

public interface BillRepository extends JpaRepository<Bill, String>{
	List<Bill> findByDate(String day1);
	List<Bill> findByStatus(int stt);
	List<Bill> findByDateAndStatus(String day1,int stt);

	@Modifying
	void deleteBillByIdbill(int id);
	@Query(value = "update from Bill b set b.status=b.status+1 where b.idbill=?1")
	@Modifying
	void updateOrder(int ids);

	@Query(value = "SELECT count (b) from Bill b")
	int getNumberBillCurrent();
	@Query(value ="SELECT b FROM Bill b where b.user.username=?1 order by 1 desc")
	List<Bill> getBillByUser(String username);
}
