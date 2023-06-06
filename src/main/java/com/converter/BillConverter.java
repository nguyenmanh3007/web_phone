package com.converter;

import org.springframework.stereotype.Component;

import com.dto.BillDTO;
import com.model.Bill;

@Component
public class BillConverter {
	public BillDTO toDto(Bill bill) {
		BillDTO billDTO= new BillDTO();
		billDTO.setIdbill(bill.getIdbill());
		billDTO.setCountry(bill.getCountry());
		billDTO.setCity(bill.getCity());
		billDTO.setCountry(bill.getCountry());
		billDTO.setHn(bill.getHn());
		billDTO.setCounty(bill.getCounty());
		billDTO.setPhone(bill.getPhone());
		billDTO.setDate(bill.getDate());
		billDTO.setTotal(bill.getTotal());
		billDTO.setUsername(bill.getUsername());
		billDTO.setProducts(bill.getProducts());
		billDTO.setStatus(bill.getStatus());
		return billDTO;
	}
	public Bill toEntity(BillDTO bill) {
		Bill billDTO= new Bill();
		billDTO.setIdbill(bill.getIdbill());
		billDTO.setCountry(bill.getCountry());
		billDTO.setCity(bill.getCity());
		billDTO.setCountry(bill.getCountry());
		billDTO.setHn(bill.getHn());
		billDTO.setCounty(bill.getCounty());
		billDTO.setPhone(bill.getPhone());
		billDTO.setDate(bill.getDate());
		billDTO.setTotal(bill.getTotal());
		billDTO.setUsername(bill.getUsername());
		billDTO.setProducts(bill.getProducts());
		billDTO.setStatus(bill.getStatus());
		return billDTO;
	}
}
