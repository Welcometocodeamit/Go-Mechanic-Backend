package com.gomechanic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.gomechanic.models.MailStructure;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
	private String fromMail;
	
	public void sendMail(String mail, MailStructure mailStructure) {
		
		SimpleMailMessage simplemailMessage = new SimpleMailMessage();
		simplemailMessage.setFrom(fromMail);
		simplemailMessage.setSubject(mailStructure.getSubject());
		simplemailMessage.setText(mailStructure.getMessage());
		simplemailMessage.setTo(mail);
		
		mailSender.send(simplemailMessage);
		
	}

}
