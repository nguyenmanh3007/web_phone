package com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jwt.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter();
	}
	@Bean(BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(customUserDetailsService) // cung cap customUserDetailService cho spring
		.passwordEncoder(passwordEncoder());			  // cung cap password encoder
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors() // Ngan chan request tu mot domain khac
		.and().csrf().disable()
		.authorizeRequests()
		.antMatchers("/assets/**","/assets1/**","/bootstrap/**","/css/**","/fonts/**","/img/**","/js/**","/paging/**","/filter.js","/lienhe.css","/main.css","/style.css","/style1.css","/style2.css").permitAll()
		//login
		.antMatchers("/","/adminLogin","/userForm","/checkLogin-admin","/checkLogin","/checkRegister").permitAll()
		//admin
		.antMatchers("/admin/**","/admin/product/**").hasRole("ADMIN")
		//admin-api
		.antMatchers("/api/admin","/api/bill","/api/product","/api/user").hasRole("ADMIN")
		//User
		.antMatchers("/userContact","/sendMail","/filterProduct","/add-to-cart","/user-cart","/user-checkout","/user-order").hasRole("USER")
		//user-api
		.antMatchers("/api/web/bill","api/cart","api/cartNumber","api/web/product").hasRole("USER")
		//api-login
		.antMatchers("/api/v1/auth/**").permitAll()
		.antMatchers("/api/v1/test/**").permitAll()
		.anyRequest().authenticated();
		
		//Them mot filter de kiem tr jwt
		http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		
	}

}
