package com.ap.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component 
public class EmailUtils {
	
	
	@Autowired
	private JavaMailSender mailSender;
	
	
	public boolean sendEmail(String subject,String body,String to) throws MessagingException {
		
		
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		
		MimeMessageHelper helper=new MimeMessageHelper(mimeMessage, true);
		helper.setSubject(subject);
		helper.setText(body,true);
		helper.setTo(to);
		
		mailSender.send(mimeMessage);

		return true;
	}

}
