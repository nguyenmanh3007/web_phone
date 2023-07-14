package com.Controller.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jwt.JwtTokenProvider;
import com.model.Carts;
import com.model.User;
import com.service.CartMethod;
import com.service.ProductMethod;
import com.service.UserMethod;

@Controller(value = "userControllerOfWeb")
public class UserController {
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	@Autowired
	private UserMethod userMethod;

	@Autowired
	private ProductMethod productMethod;

	@Autowired
	private CartMethod cartMethod;

	@Autowired
	JavaMailSender mail;

	@GetMapping("/")
	public ModelAndView shop() {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

	@GetMapping("/userForm")
	public ModelAndView index(@RequestParam(value = "message",required = false) String message) {
		ModelAndView mav = new ModelAndView("Login");
		mav.addObject("message", message);
		mav.addObject("user", new User());
		mav.addObject("userdk", new User());
		return mav;
	}

	@GetMapping("/checkLogin")
	public ModelAndView useLogin(@RequestParam(name="token",required=false) String token,@RequestParam(name="message") String mess,HttpSession session) {
		ModelAndView mav = new ModelAndView("usershop");
		ModelAndView mavTwo = new ModelAndView("Login");
		if(mess.equals("error_system")) {
			mavTwo.addObject("message", "Username or password invalid!!!");
			mavTwo.addObject("userdk", new User());
			return mavTwo;
		}
		else {
			String userna= jwtTokenProvider.getUserNameFromJwt(token);
			session.setAttribute("user", userna);
			String username = (String) session.getAttribute("user");
			mav.addObject("listProduct", productMethod.getProductByQuantity());
			mav.addObject("username", username);
			List<Carts> listOne = cartMethod.getInfoCart(username);
			int sumT = 0;
			for (Carts carts : listOne) {
				sumT += carts.getTotal();
			}
			mav.addObject("sumT", sumT);
			int a = cartMethod.getCountCart(username);
			mav.addObject("cCart", a);
			return mav;
		}
	}

	@PostMapping("/checkRegister")
	public ModelAndView userdk(User user) {
		ModelAndView mav = new ModelAndView("Login");
		if (userMethod.findByUsername(user.getUsername()) == null) {
			userMethod.save(user);
			mav.addObject("mess1", "registion suscessful!!");
			return mav;
		}
		mav.addObject("mess", "username existed!!!");
		return mav;
	}

	@GetMapping("/userContact")
	public ModelAndView contactF(HttpSession session) {
		ModelAndView mav = new ModelAndView("contact");
		mav.addObject("username", session.getAttribute("user"));
		String username = (String) session.getAttribute("user");
		List<Carts> listOne = cartMethod.getInfoCart(username);
		int sumT = 0;
		for (Carts carts : listOne) {
			sumT += carts.getTotal();
		}
		mav.addObject("sumT", sumT);
		int a = cartMethod.getCountCart(username);
		mav.addObject("cCart", a);
		return mav;
	}

	@PostMapping("/sendMail")
	public ModelAndView sendMailer(@RequestParam("to") String to, @RequestParam("sj") String sj,
			@RequestParam("mess") String mess, Model model) {
		ModelAndView mav = new ModelAndView("contact");
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("nguyenmanh.ptit.3007@gmail.com");
		msg.setTo(to);
		msg.setSubject(sj);
		msg.setText(mess);
		mail.send(msg);
		return mav;
	}
}
