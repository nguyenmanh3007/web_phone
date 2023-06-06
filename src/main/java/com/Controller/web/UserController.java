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
		ModelAndView mav= new ModelAndView("index");
		return mav;
	}
	@GetMapping("/userForm")
    public ModelAndView index() {
	 ModelAndView mav= new ModelAndView("Login");
   	 mav.addObject("user", new User());
   	 mav.addObject("userdk", new User());
   	 return mav;
    }
	@PostMapping("/userlogin")
	public ModelAndView useLogin(User user,HttpSession session) {
		ModelAndView mavOne= new ModelAndView("usershop");
		ModelAndView mavTwo= new ModelAndView("Login");
		session.setAttribute("user", user.getUsername());
		String username=(String) session.getAttribute("user");
		if( userMethod.existsByUsernameAndPass(user.getUsername(), user.getPass())==true) {
			mavOne.addObject("listProduct", productMethod.getProductByQuantity());
			mavOne.addObject("username", username);
			List<Carts> listOne= cartMethod.getInfoCart(username);
			int sumT = 0;
			for(Carts carts: listOne) {
				sumT += carts.getTotal();
			}
			mavOne.addObject("sumT", sumT);
			int a = cartMethod.getCountCart(username);
			mavOne.addObject("cCart", a);
			return mavOne;
		}
		mavTwo.addObject("message", "User not exist!!!");
		return mavTwo;
	}
	@PostMapping("/loginCtl")
	public ModelAndView userdk(User user) {
		ModelAndView mav= new ModelAndView("Login");
		if(userMethod.findByUsername(user.getUsername())==null) {
			userMethod.save(user);
			mav.addObject("mess1","registion suscessful!!");
			return mav;
		}
		mav.addObject("mess", "username existed!!!");
		return mav;
	}
	@GetMapping("/contactForm")
	public ModelAndView  contactF(HttpSession session) {
		ModelAndView mav= new ModelAndView("contact");
		mav.addObject("username", session.getAttribute("user"));
		String username = (String) session.getAttribute("user");
		List<Carts> listOne= cartMethod.getInfoCart(username);
		int sumT = 0;
		for(Carts carts: listOne) {
			sumT += carts.getTotal();
		}
		mav.addObject("sumT", sumT);
		int a = cartMethod.getCountCart(username);
		mav.addObject("cCart", a);
		return mav;
	}
	
	@PostMapping("/sendMail")
	public ModelAndView sendMailer(@RequestParam("to") String to, @RequestParam("sj") String sj, @RequestParam("mess") String mess, Model model) {
		ModelAndView mav= new ModelAndView("contact");
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom(to);
		msg.setTo("nguyenmanh.2014.1102@gmail.com");
		msg.setSubject(sj);
		msg.setText(mess);
		mail.send(msg);
		return mav;
	}
}
