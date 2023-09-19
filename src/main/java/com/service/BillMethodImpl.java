package com.service;

import java.text.SimpleDateFormat;
import java.util.*;

import com.dto.CartDTO;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Repository.BillRepository;
import com.converter.BillConverter;
import com.dto.BillDTO;
import com.model.Bill;
@Repository
@Service
@RequiredArgsConstructor
public class BillMethodImpl implements BillMethod {
	private final BillRepository billRepository;
	private final BillConverter billConverter;
	private final CartMethod cartMethod;
	private final UserMethod userMethod;
	private final ProductMethod productMethod;
	@Override
	public Iterable<Bill> findAll() {
		return billRepository.findAll();
	}

	@Override
	public void save(Bill bill) {
		billRepository.save(bill);
	}

	@Override
	public void delete(Bill bill) {
		billRepository.delete(bill);
	}

	@Override
	public List<Bill> findByDate(String day1) {
		return billRepository.findByDate(day1);
	}

	@Override
	public Map<String, List<BillDTO>> getAllBill() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		List<Bill> bDay= findByDateAndStatus(currentDate,2);
		bDay.forEach(x-> Hibernate.initialize(x.getUser()));
		List<Bill> bHistory= (List<Bill>) findAll();
		bHistory.forEach(x-> Hibernate.initialize(x.getUser()));
		List<BillDTO> listBillDay= new ArrayList<>();
		List<BillDTO> listBillMonth= new ArrayList<>();
		List<BillDTO> listBillHistory= new ArrayList<>();
		for(Bill b: bDay) {
			listBillDay.add(billConverter.toDto(b));
		}
		for(Bill m: bHistory) {
			if(m.getDate().substring(0, m.getDate().length()-3).trim().equals(currentDate.substring(0, currentDate.length()-3).trim()) && m.getStatus()==2) {
				listBillMonth.add(billConverter.toDto(m));
			}
		}
		for(Bill a: bHistory) {
			if(a.getStatus()==2)
				listBillHistory.add(billConverter.toDto(a));
		}
		Map<String,List<BillDTO>> bills=new HashMap<>();
		bills.put("bDay",listBillDay);
		bills.put("bMonth",listBillMonth);
		bills.put("bHistory",listBillHistory);
		return bills;
	}

	@Override
	@Transactional
	public BillDTO create(BillDTO billDTO,String name) {
		List<CartDTO> list= cartMethod.getInfoCart(name);
		for(CartDTO cartDTO: list) {
			cartMethod.updateQuantityProduct(cartDTO.getIdproduct(), cartDTO.getNum());
		}
		int idBill=1;
		if(billRepository.getNumberBillCurrent()>0){
			idBill=billRepository.getNumberBillCurrent()+1;
		}
		String listp = "";
		for(CartDTO cartDTO: list) {
			listp += cartDTO.getNameproduct()+" x"+cartDTO.getNum()+"; ";
		}
		BillDTO billResult= BillDTO.builder()
				.country(billDTO.getCountry())
				.county(billDTO.getCounty())
				.city(billDTO.getCity())
				.hn(billDTO.getHn())
				.phone(billDTO.getPhone())
				.total(cartMethod.getTotalCartByUsername(name))
				.user(userMethod.findByUsername(name))
				.date(new SimpleDateFormat("yyyy/MM/dd").format(new Date()))
				.idbill(idBill)
				.products(listp)
				.status(0)
				.build();
		cartMethod.deleteAllByUser(name);
		return billConverter.toDto(billRepository.save(billConverter.toEntity(billResult)));
	}

	@Override
	public List<Bill> getBillByUser(String username) {
		return billRepository.getBillByUser(username);
	}

	@Override
	@Transactional
	public void deleteBillById(int id) {
		billRepository.deleteBillByIdbill(id);
	}

	@Override
	public List<Bill> findByStatus(int stt) {
		return billRepository.findByStatus(stt);
	}

	@Override
	public List<Bill> findByDateAndStatus(String day1, int stt) {
		return billRepository.findByDateAndStatus(day1, stt);
	}

	@Override
	@Transactional
	public void updateOrder(int ids) {
		billRepository.updateOrder(ids);
	}
}
