package com.cab.Service;

import com.cab.Model.Subscription;
import com.cab.Repositary.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class SubscriptionServiceImpl {
    @Value("${spring.mail.username}")
    private String from;

    @Value("${spring.mail.password}")
    private String password;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public void subscribe(String email) {
        // Check if the email is already subscribed
        if (subscriptionRepository.existsByEmail(email)) {
            System.out.println("Email already subscribed.");
            return;
        }

        // Save email to database
        Subscription subscription = new Subscription();
        subscription.setEmail(email);
        subscriptionRepository.save(subscription);

        // Send confirmation email
        sendEmailNotification(email);
    }

    private void sendEmailNotification(String email) {
        String to = email;

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(from));
            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            mimeMessage.setSubject("Subscription Confirmation");

            // HTML Content for the email
            StringBuilder emailContent = new StringBuilder();
        	emailContent.append("</table>")
        	.append("<p>Thank you for subscribing to our Cab Services! Stay tuned for updates.</p>")
        	.append("<p>--</p>")
        	.append("<p>Thanks & Regards,</p>")
        	.append("<p><strong>HR Department | WEBLABS GROUP</strong></p>")
        	.append("<p>Telephone: +91 9701999033</p>")
        	.append("<p>Email: HR@weblabstech.com</p>")
        	.append("<p>Website: <a href='https://www.weblabstech.com'>www.weblabstech.com</a></p>")
        	.append("</body></html>");
        	// Close the HTML table and body
        	emailContent
        	            .append("</body></html>");


            mimeMessage.setContent(emailContent.toString(), "text/html");

            Transport.send(mimeMessage);
            System.out.println("HTML Email sent successfully.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
