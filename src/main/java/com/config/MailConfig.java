package com.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class MailConfig {

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("nguyenmanh.2014.1102@gmail.com");
        mailSender.setPassword("ccvolizqxllkqdev");

        Properties mp = new Properties();
	     mp.put("mail.smtp.auth", true);
	     mp.put("mail.smtp.starttls.enable", true);
	     mp.put("mail.transport.protocol", "smtp");
	     mp.put("mail.smtp.ssl.protocols", "TLSv1.2");
	     mp.put("mail.debug", "true");
	     mailSender.setJavaMailProperties(mp);

        return mailSender;
	}
	@Bean
	public CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver resolver = new CommonsMultipartResolver();
	    resolver.setMaxUploadSize(110000);
	    return resolver;
	}
}
