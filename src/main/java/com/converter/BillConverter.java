package com.converter;

import org.springframework.stereotype.Component;

import com.dto.BillDTO;
import com.model.Bill;

@Component
public class BillConverter {
	public BillDTO toDto(Bill bill) {
		BillDTO billDTO= BillDTO.builder()
				.idbill(bill.getIdbill())
				.country(bill.getCountry())
				.city(bill.getCity())
				.county(bill.getCounty())
				.hn(bill.getHn())
				.phone(bill.getPhone())
				.date(bill.getDate())
				.total(bill.getTotal())
				.user(bill.getUser())
				.products(bill.getProducts())
				.status(bill.getStatus())
				.build();
		return billDTO;
	}
	public Bill toEntity(BillDTO billDTO) {
		Bill bill = Bill.builder()
				.idbill(billDTO.getIdbill())
				.country(billDTO.getCountry())
				.city(billDTO.getCity())
				.county(billDTO.getCounty())
				.hn(billDTO.getHn())
				.phone(billDTO.getPhone())
				.date(billDTO.getDate())
				.total(billDTO.getTotal())
				.user(billDTO.getUser())
				.products(billDTO.getProducts())
				.status(billDTO.getStatus())
				.build();
		return bill;
	}
}
