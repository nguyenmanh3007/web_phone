package com.api.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dto.BillDTO;
import com.service.BillMethod;

@RestController(value = "BillAPIOfWeb")
@RequiredArgsConstructor
public final class BillAPI {
	private final BillMethod billMethod;
	@PostMapping("/api/web/bill")
	public BillDTO createBill(@RequestBody BillDTO bill,HttpSession session){
		return billMethod.create(bill, (String) session.getAttribute("user"));
	}
	@DeleteMapping("api/web/bill")
	public void deleteCart(@RequestBody String ids) {
			String id= ids.substring(1,ids.length()-1);
			billMethod.deleteBillById(Integer.parseInt(id));
	}
	@PutMapping("/api/web/bill")
	public ResponseEntity<?> updateOrder(@RequestBody int ids) {
		billMethod.updateOrder(ids);
		return ResponseEntity.accepted().body("oke!!");
	}
}
