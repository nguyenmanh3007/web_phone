package com.Controller.web;


import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.jwt.JwtTokenProvider;
import com.model.User;
import com.service.CartMethod;
import com.service.ProductMethod;
import com.service.UserMethod;

@Controller(value = "userControllerOfWeb")
@RequiredArgsConstructor
public class UserController {
	private final JwtTokenProvider jwtTokenProvider;
	private final UserMethod userMethod;
	private final ProductMethod productMethod;
	private final CartMethod cartMethod;
	private final JavaMailSender mail;

	@GetMapping("/")
	public ModelAndView shop() {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}

	@GetMapping("/userForm")
	public ModelAndView index(@RequestParam(value = "message",required = false) String message) {
		ModelAndView mav = new ModelAndView("Login");
		mav.addObject("message", message);
		return mav;
	}

	@GetMapping("/checkLogin")
	public ModelAndView useLogin(@RequestParam(name="token",required=false) String token,@RequestParam(name="message") String mess,HttpSession session) {
		ModelAndView mav = new ModelAndView("usershop");
		ModelAndView mavTwo = new ModelAndView("Login");
		if(mess.equals("error_system")) {
			mavTwo.addObject("message", "Username or password invalid!!!");
			return mavTwo;
		}
		else {
			String userNameFromJwt= jwtTokenProvider.getUserNameFromJwt(token);
			session.setAttribute("user", userNameFromJwt);
			String username = (String) session.getAttribute("user");
			mav.addObject("listProduct", productMethod.getProductByQuantity());
			mav.addObject("username", username);
			mav.addObject("sumT", cartMethod.getTotalCartByUsername(username));
			mav.addObject("cCart", cartMethod.getCountCart(username));
			return mav;
		}
	}

	@PostMapping("/checkRegister")
	public ModelAndView userdk(User user) {
		ModelAndView mav = new ModelAndView("Login");
		if (userMethod.findByUsername(user.getUsername()) == null) {
			userMethod.save(user);
			mav.addObject("mess1", "sign up successful");
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
		mav.addObject("sumT", cartMethod.getTotalCartByUsername(username));
		mav.addObject("cCart", cartMethod.getCountCart(username));
		return mav;
	}

	@PostMapping("/sendMail")
	public ModelAndView sendMailer(@RequestParam("to") String to, @RequestParam("sj") String sj,
			@RequestParam("mess") String mess) {
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
