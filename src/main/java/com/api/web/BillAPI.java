package com.api.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dto.BillDTO;
import com.dto.cartDTO;
import com.service.BillMethod;
import com.service.CartMethod;

@RestController(value = "BillAPIOfWeb")
public class BillAPI {
	@Autowired
	private BillMethod billMethod;
	@Autowired
	private CartMethod cartMethod;
	@PostMapping("/api/web/bill")
	public BillDTO saveBill(@RequestBody BillDTO bill,HttpSession session){
		String name= (String) session.getAttribute("user");
		//List<Carts> list = cartMethod.getInfoCart(name);
		List<cartDTO> list= cartMethod.getInfoCart(name);
		int sumT = 0;
		for(cartDTO cartDTO: list) {
			sumT += cartDTO.getTotal();
		}
		for(cartDTO cartDTO: list) {
			cartMethod.udProduct(cartDTO.getIdproduct(), cartDTO.getNum());
		}
		bill.setTotal(sumT);
		bill.setUsername(name);
		Date datee = new Date();
        String ngayMua = new SimpleDateFormat("yyyy/MM/dd").format(datee.getTime());
		bill.setDate(ngayMua);
		int idb = cartMethod.getIdBill();
		bill.setIdbill(idb+1);
		String listp = "";
		for(cartDTO cartDTO: list) {
			listp += cartDTO.getNameproduct()+" x"+cartDTO.getNum()+"; ";
		}
		bill.setProducts(listp);
		bill.setStatus(0);
		cartMethod.deleteAllByUsername(name);
		return billMethod.create(bill);
	}
	@DeleteMapping("api/web/bill")
	public void deleteCart(@RequestBody String ids) {
			String id= ids.substring(1,ids.length()-1);
			billMethod.deleteBillById(Integer.parseInt(id));
	}
}
