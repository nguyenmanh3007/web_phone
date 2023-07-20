package com.api.inup;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.JwtTokenProvider;
import com.model.ERole;
import com.model.Roles;
import com.model.User;
import com.payload.request.LoginRequest;
import com.payload.request.SignupRequest;
import com.payload.response.JwtResponse;
import com.payload.response.MessageResponse;
import com.security.CustomUserDetails;
import com.service.RoleMethod;
import com.service.UserMethod;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1/auth")
public class UserController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenProvider tokenProvider;
	@Autowired
	private UserMethod userService;
	@Autowired
	private RoleMethod roleService;
	@Autowired
	private PasswordEncoder encoder;

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest) {
		if (userService.existsByUserName(signupRequest.getUserName())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Username is already"));
		}
		if (userService.existsByEmail(signupRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Email is already"));
		}
		User users = new User();
		users.setUsername(signupRequest.getUserName());
		users.setPassword(encoder.encode(signupRequest.getPassword()));
		users.setEmail(signupRequest.getEmail());
		users.setFname(signupRequest.getFname());
		users.setLname(signupRequest.getLname());
		Set<String> strRoles = signupRequest.getListRoles();
		Set<Roles> listRoles = new HashSet<>();
		if (strRoles == null) {
			// User quyen mac dinh
			Roles userRole = roleService.findByRoleName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found"));
			listRoles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Roles adminRole = roleService.findByRoleName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found"));
					listRoles.add(adminRole);
					break;
				case "user":
					Roles userRole = roleService.findByRoleName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found"));
					listRoles.add(userRole);
					break;
				}

			});
		}
		users.setListRoles(listRoles);
		userService.save(users);
		return ResponseEntity.ok(new MessageResponse("User registered successfully"));
	}

	@PostMapping("/signin")
	public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
		Authentication authentication=authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),loginRequest.getPassword())
				);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
		System.out.print(customUserDetails);
		//sinh JWT tra ve Client
		String jwt = tokenProvider.generateToken(customUserDetails);
		//Lay cac quyen cua user
		List<String> listRoles=customUserDetails.getAuthorities().stream()
				.map(item->item.getAuthority()).collect(Collectors.toList());
		return ResponseEntity.ok(new JwtResponse(jwt,"bearer", customUserDetails.getUsername(),customUserDetails.getPassword(), customUserDetails.getEmail(),customUserDetails.getFname(),customUserDetails.getLname(), listRoles));
	}
	@PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) {
        // Xóa các thông tin đăng nhập khỏi SecurityContextHolder
        SecurityContextHolder.clearContext();

        // Xóa session
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // Xóa cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                cookie.setValue(null);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
        return ResponseEntity.ok(new MessageResponse("Logout successfully"));
    }
}
