
package com.cab.Service;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OTPGenerator {
	@Autowired
	OTPService otpsrv;
	private static final String FROM_EMAIL = "testing.weblabs@gmail.com"; // Replace with your Gmail address
	private static final String FROM_PASSWORD = "egon pdfr kxps hmki"; // Replace with your Gmail app password

	public String sendOTPEmail(String toEmail) {
		String otp = generateOTP(toEmail);
		String subject = "Password Reset OTP";
		String body = "Your OTP for password reset is: " + otp
				+ " valid for 10 minutes click here to reset password now : http://localhost:3000/EnterOTP?email="+toEmail;
				
		sendEmail(toEmail, subject, body);
		return otp;
	}

	private String generateOTP(String email) {
		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
		// Get or create a session
//        HttpSession session = request.getSession(true);
//		session.setAttribute("otpCreationTime", System.currentTimeMillis());
		
		otpsrv.storeOTP(email, otp);
		System.out.println("email" + email + " " + "otp" + otp);
		return String.valueOf(otp);
	}

	public void sendEmail(String toEmail, String subject, String body) {
		Properties properties = System.getProperties();
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
			message.setText(body);
			Transport.send(message);
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
	
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