package com.service;

import java.util.List;
import java.util.stream.Collectors;

import com.converter.UserConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.Repository.UserRepository;
import com.dto.UserDTO;
import com.model.User;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class UserMethodImpl implements UserMethod {
    private final UserRepository userRepository;
    private final UserConverter userConverter;
	private final JavaMailSender javaMailSender;

	@Override
	@Async
	public void sendEmail(String mail, String username, String password) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
		String htmlMsg = "<h3>Congratulations on your successful account creation</h3>"
				+ "<img src='https://ncc.asia/images/logo/logo.png'>";
		message.setContent(htmlMsg, "text/html");
		message.setText("username: " + username);
		message.setText("password: " + password);
		//FileSystemResource file = new FileSystemResource(new File("test.txt"));
		//helper.addAttachment("Demo Mail", file);
		helper.setTo(mail);
		helper.setSubject("Notice of successful registration!");
		javaMailSender.send(message);
	}

	@Override
	public User findByUsername(String user) {
		return userRepository.findByUsername(user);
	}

	@Override
	public UserDTO getListUser(int page, int limit) {
		UserDTO userDTO = new UserDTO();
		userDTO.setPage(page);
		Pageable pageable= PageRequest.of(page-1, limit);
		userDTO.setListResult(findAll(pageable));
		userDTO.setTotalPage((int) Math.ceil((double)(getTotalItem()) / limit));
		return userDTO;
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}
	@Override
	public List<UserDTO> findAll(Pageable pageable) {
		List<User> lUser= userRepository.findAll(pageable).getContent();
		return lUser.stream().map(user -> userConverter.toDTO(user)).collect(Collectors.toList());
	}
	@Override
	public int getTotalItem() {
		return (int) userRepository.count();
	}
	@Override
	public User findByEmail(String user) {
		return userRepository.findByEmail(user);
	}
	@Override
	public boolean existsByUserName(String un) {
		return userRepository.existsByUsername(un);
	}
	@Override
	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}
}
