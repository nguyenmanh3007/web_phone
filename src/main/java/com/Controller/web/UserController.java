package com.Controller.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.model.Carts;
import com.model.User;
import com.service.CartMethod;
import com.service.ProductMethod;
import com.service.UserMethod;

@Controller(value = "userControllerOfWeb")
public class UserController {
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
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("Login");
		mav.addObject("user", new User());
		mav.addObject("userdk", new User());
		return mav;
	}

	@GetMapping("/userlogin")
	public ModelAndView useLogin(HttpSession session) {
		ModelAndView mav = new ModelAndView("usershop");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        session.setAttribute("user", userMethod.findByEmail(userDetails.getUsername()).getUsername());
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

	@PostMapping("/loginCtl")
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

	@GetMapping("/contactForm")
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
		msg.setFrom(to);
		msg.setTo("nguyenmanh.2014.1102@gmail.com");
		msg.setSubject(sj);
		msg.setText(mess);
		mail.send(msg);
		return mav;
	}
}
