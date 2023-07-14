package com.Controller.admin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.converter.BillConverter;
import com.dto.AdminDTO;
import com.dto.BillDTO;
import com.google.gson.Gson;
import com.jwt.JwtTokenProvider;
import com.model.Admin;
import com.model.Bill;
import com.model.User;
import com.service.AdminMethod;
import com.service.BillMethod;
import com.service.UserMethod;

@Controller(value = "adminControllerOfAdmin")
public class AdminController {
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	@Autowired
	private BillMethod billMethod;
	@Autowired
	private BillConverter billConverter;
	@Autowired
	private AdminMethod adminMethod;
	@Autowired
	private UserMethod userMethod;
	@GetMapping("/adminLogin")
	public ModelAndView lga() {
		ModelAndView mav= new ModelAndView("AdminLogin");
		mav.addObject("admin", new Admin());
		return mav;
	}
	@GetMapping("/checkLogin-admin")
	public ModelAndView dashboard(@RequestParam(name="token",required=false) String token,@RequestParam(name="message") String mess, HttpSession session) {
		ModelAndView mavOne= new ModelAndView("dashboard");
		ModelAndView mavTwo= new ModelAndView("AdminLogin");
		String username= jwtTokenProvider.getUserNameFromJwt(token);
		User user = userMethod.findByUsername(username);
		if(mess.equals("error_system") || adminMethod.checkRoleAdmin(user)==false) {
			mavTwo.addObject("message", "Username or password invalid!!!");
			mavTwo.addObject("admin", new Admin());
			return mavTwo;
		}
		else {
			session.setAttribute("username", username);
			Date datee = new Date();
			String ngay = new SimpleDateFormat("yyyy-MM-dd").format(datee.getTime());
			List<Bill> day= billMethod.findByDateAndStatus(ngay,2);
			List<Bill> ago= (List<Bill>) billMethod.findAll();
			List<BillDTO> lOne= new ArrayList<>();
			List<BillDTO> lTwo= new ArrayList<>();
			List<BillDTO> lThree= new ArrayList<>();
			for(Bill b: day) {
				lOne.add(billConverter.toDto(b));
			}
			for(Bill m:ago) {
				if(m.getDate().substring(0, m.getDate().length()-3).trim().equals(ngay.substring(0, ngay.length()-3).trim()) && m.getStatus()==2) {
					lTwo.add(billConverter.toDto(m));
				}
			}
			for(Bill a:ago) {
				if(a.getStatus()==2)
					lThree.add(billConverter.toDto(a));
			}
			mavOne.addObject("list", lOne);
			mavOne.addObject("list1", lTwo);
			mavOne.addObject("list3", lThree);
			//session.setAttribute("admin", admin.getUsername());
			mavOne.addObject("username", session.getAttribute("admin"));
			return mavOne;
		}
	}
	@GetMapping("/admin/listAdmin")
	public ModelAndView stat(@RequestParam(name = "AdminDTO", required = false) String adminDto,HttpSession session) {
		ModelAndView mav= new ModelAndView("listAdmin");
		mav.addObject("username", session.getAttribute("admin"));
		if (adminDto != null) {
            Gson gson = new Gson();
            AdminDTO adminDTO = gson.fromJson(adminDto, AdminDTO.class);
            mav.addObject("list", adminDTO.getListResult());
        }
		return mav;
	}
}
