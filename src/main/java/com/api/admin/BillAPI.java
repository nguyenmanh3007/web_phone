package com.api.admin;

import java.util.List;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.dto.BillDTO;
import com.service.BillMethod;

@RestController
@RequiredArgsConstructor
public class BillAPI {
	private final BillMethod billMethod;
	
	@GetMapping("/api/bill")
	public BillDTO getAllBill(){
		BillDTO billDTO= new BillDTO();
		Map<String,List<BillDTO>> bills=billMethod.getAllBill();
		billDTO.setListResult(bills.get("bDay"));
		billDTO.setListResultTwo(bills.get("bMonth"));
		billDTO.setListResultThree(bills.get("bHistory"));
		return billDTO;
	}
	@PutMapping("/api/bill")
	public ResponseEntity<?> updateOrder(@RequestBody int ids) {
		billMethod.updateOrder(ids);
		return ResponseEntity.accepted().body("oke!!");
	}
}
