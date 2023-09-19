package com.Controller.admin;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.dto.AdminDTO;
import com.dto.BillDTO;
import com.google.gson.Gson;
import com.jwt.JwtTokenProvider;
import com.model.Admin;
import com.model.User;
import com.service.AdminMethod;
import com.service.BillMethod;
import com.service.UserMethod;

@Controller(value = "adminControllerOfAdmin")
@RequiredArgsConstructor
public class AdminController {
	private final JwtTokenProvider jwtTokenProvider;
	private final BillMethod billMethod;
	private final AdminMethod adminMethod;
	private final UserMethod userMethod;
	@GetMapping("/adminLogin")
	public ModelAndView loginAdminPage() {
		ModelAndView mav= new ModelAndView("AdminLogin");
		return mav;
	}
	@GetMapping("/checkLogin-admin")
	public ModelAndView dashboard(@RequestParam(name="token",required=false) String token,@RequestParam(name="message",required = false) String mess, HttpSession session) {
		ModelAndView mavOne= new ModelAndView("dashboard");
		ModelAndView mavTwo= new ModelAndView("AdminLogin");
		if(mess == null && token==null){
			Map<String,List<BillDTO>> bills= billMethod.getAllBill();
			mavOne.addObject("list", bills.get("bDay"));
			mavOne.addObject("list1", bills.get("bMonth"));
			mavOne.addObject("list3", bills.get("bHistory"));
			mavOne.addObject("username", session.getAttribute("admin"));
			return mavOne;
		}
		else if(mess.equals("error_system")) {
			mavTwo.addObject("message", "Username or password invalid!!!");
			return mavTwo;
		}
		else {
			String username = jwtTokenProvider.getUserNameFromJwt(token);
			User user = userMethod.findByUsername(username);
			if (adminMethod.checkRoleAdmin(user) == false) {
				mavTwo.addObject("message", "You do not have permission to access this address!!!");
				return mavTwo;
			} else {
				session.setAttribute("username",", "+ username);
				Map<String,List<BillDTO>> bills= billMethod.getAllBill();
				mavOne.addObject("list", bills.get("bDay"));
				mavOne.addObject("list1", bills.get("bMonth"));
				mavOne.addObject("list3", bills.get("bHistory"));
				mavOne.addObject("username", session.getAttribute("admin"));
				return mavOne;
			}
		}
	}
	@GetMapping("/admin/listAdmin")
	public ModelAndView stat(@RequestParam(name = "AdminDTO", required = false) String adminDto,HttpSession session) {
		ModelAndView mav= new ModelAndView("listAdmin");
		mav.addObject("username", session.getAttribute("username"));
		if (adminDto != null) {
            Gson gson = new Gson();
            AdminDTO adminDTO = gson.fromJson(adminDto, AdminDTO.class);
            mav.addObject("list", adminDTO.getListResult());
        }
		return mav;
	}
}
