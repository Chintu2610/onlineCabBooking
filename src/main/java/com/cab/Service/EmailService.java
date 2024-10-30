package com.cab.Service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	@Value("${spring.mail.username}")
    private String FROM_EMAIL;

    @Value("${spring.mail.password}")
    private String FROM_PASSWORD;
	public void sendEmailHtmlType(String toEmail, String subject, String body) {
	    Properties properties = new Properties();
	    properties.put("mail.smtp.host", "smtp.gmail.com");
	    properties.put("mail.smtp.port", "465");
	    properties.put("mail.smtp.ssl.enable", "true");
	    properties.put("mail.smtp.auth", "true");
	    properties.put("mail.smtp.socketFactory.port", "465");
	    properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    properties.put("mail.smtp.ssl.protocols", "TLSv1.2"); // Use TLSv1.2 protocol

	    Session session = Session.getInstance(properties, new Authenticator() {
	        @Override
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(FROM_EMAIL, FROM_PASSWORD);
	        }
	    });

	    try {
	        MimeMessage message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(FROM_EMAIL));
	        message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
	        message.setSubject(subject);

	        // Set the email body to HTML format
	        message.setContent(body, "text/html; charset=utf-8");

	        // Send the email
	        Transport.send(message);
	    } catch (MessagingException mex) {
	        mex.printStackTrace();
	    }
	}
}
