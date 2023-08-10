package com.security;

import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private final CustomUserDetailsService customUserDetailsService;
	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter();
	}
	@Bean(BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService)
		.passwordEncoder(passwordEncoder());
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors()
		.and().csrf().disable()
		.authorizeRequests()
		.antMatchers("/assets/**","/assets1/**","/bootstrap/**","/css/**","/fonts/**","/img/**","/js/**","/paging/**","/filter.js","/lienhe.css","/main.css","/style.css","/style1.css","/style2.css").permitAll()
		.antMatchers("/","/adminLogin","/userForm","/checkLogin-admin","/checkLogin","/checkRegister").permitAll()
		.antMatchers("/admin/**","/admin/product/**").hasRole("ADMIN")
		.antMatchers("/api/admin","/api/bill","/api/product","/api/user").hasRole("ADMIN")
		.antMatchers("/userContact","/sendMail","/filterProduct","/add-to-cart","/user-cart","/user-checkout","/user-order").hasAnyRole("USER","ADMIN")
		.antMatchers("/api/web/bill","api/cart","api/cartNumber","api/web/product").hasAnyRole("USER","ADMIN")
		.antMatchers("/api/v1/auth/**").permitAll()
		.antMatchers("/api/v1/test/**").permitAll()
		.anyRequest().authenticated();

		http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		
	}

}
