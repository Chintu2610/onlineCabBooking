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

    @Autowired
    private OTPGenerator optservice;
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
        StringBuilder emailContent = new
        		 StringBuilder(); emailContent.append("</table>")
        		 .append("<p>Thank you for subscribing to our Cab Services! Stay tuned for updates.</p>"
        		  ) .append("<p>--</p>") .append("<p>Thanks & Regards,</p>")
        		  .append("<p><strong>HR Department | WEBLABS GROUP</strong></p>")
        		 .append("<p>Telephone: +91 9701999033</p>")
        		  .append("<p>Email: HR@weblabstech.com</p>")
        		  .append("<p>Website: <a href='https://www.weblabstech.com'>www.weblabstech.com</a></p>"
        		  ) .append("</body></html>"); // Close the HTML table and body emailContent
        optservice.sendEmailHtmlType(email,"Subscription Successfull!",emailContent.toString());
		
    }

}
