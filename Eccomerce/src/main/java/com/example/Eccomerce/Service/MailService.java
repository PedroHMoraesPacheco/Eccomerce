package com.example.Eccomerce.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Eccomerce.Configuration.MailConfig;
import com.example.Eccomerce.Model.Mail;

@Service
public class MailService {

	@Autowired
	MailConfig mailConfig;
	
	public String createEmail(Mail mail) {
		mailConfig.sendEmail(mail.getPara(), mail.getAssunto(), mail.getTexto(),mail.getFrom());
		return "Email enviado com sucesso!!";
	}
	
}
