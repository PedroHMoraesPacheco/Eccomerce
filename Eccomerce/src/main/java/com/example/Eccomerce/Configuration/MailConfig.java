package com.example.Eccomerce.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendEmail(String para, String assunto, String texto, String from) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(para);
		message.setSubject(assunto);
		message.setText(texto);
		javaMailSender.send(message);
	}
}
