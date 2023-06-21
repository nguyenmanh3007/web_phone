package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.service.CustomerUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	CustomerUserDetailService customerUserDetailService;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/","/adminLogin","/adminForm","/userForm"
					,"/adminForm2","/admin/order","/userAdminForm","/addProductForm","/adminForm1","/productForm","/adminForm2"
					,"/api/admin","/api/bill","/api/product","/api/user"
					,"/assets/**","/assets1/**","/css/**","/js/**","/img/**","/fonts/**" ,"/style.css","/style1.css","/style2.css").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/userForm")
				.defaultSuccessUrl("/userlogin")
				.failureUrl("/userForm?sucess=false")
				.loginProcessingUrl("/j_spring_security_check")
			;
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(customerUserDetailService).passwordEncoder(passwordEncoder());
//		auth
//        .inMemoryAuthentication()
//        .withUser("user1")
//        .password(passwordEncoder().encode("123"))
//        .authorities("ROLE_USER");
	}
}
