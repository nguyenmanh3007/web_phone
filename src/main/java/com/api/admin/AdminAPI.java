package com.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.AdminDTO;
import com.service.AdminMethod;

@RestController
public class AdminAPI {
	@Autowired
	private AdminMethod adminMethod;
	@GetMapping("/api/admin")
	public AdminDTO showAdmin(){
		AdminDTO adminDTO= new AdminDTO();
		adminDTO.setListResult(adminMethod.getfindAll());
		return adminDTO;
	}
//	@PostMapping("/api/admin")
//	public ResponseEntity<?> login(@RequestBody AdminDTO adminDTO){
//		if(adminMethod.existsByUsernameAndPassword(adminDTO.getUsername(), adminDTO.getPassword())==true) {
//			BillDTO billDTO= new BillDTO();
//			Date datee = new Date();
//			String ngay = new SimpleDateFormat("yyyy-MM-dd").format(datee.getTime());
//			List<Bill> day= billMethod.findByDateAndStatus(ngay,2);
//			List<Bill> ago= (List<Bill>) billMethod.findAll();
//			List<BillDTO> lOne= new ArrayList<>();
//			List<BillDTO> lTwo= new ArrayList<>();
//			List<BillDTO> lThree= new ArrayList<>();
//			for(Bill b: day) {
//				lOne.add(billConverter.toDto(b));
//			}
//			for(Bill m:ago) {
//				if(m.getDate().substring(0, m.getDate().length()-3).trim().equals(ngay.substring(0, ngay.length()-3).trim()) && m.getStatus()==2) {
//					lTwo.add(billConverter.toDto(m));
//				}
//			}
//			for(Bill a:ago) {
//				if(a.getStatus()==2)
//					lThree.add(billConverter.toDto(a));
//			}
//			billDTO.setListResult(lOne);
//			billDTO.setListResultTwo(lTwo);
//			billDTO.setListResultThree(lThree);
//			billDTO.setUsername(adminDTO.getUsername());
//			return ResponseEntity.ok(billDTO);
//		}
//		else {
//			return ResponseEntity.badRequest().body("Admin not existed!!!");
//		}
//	}
}
