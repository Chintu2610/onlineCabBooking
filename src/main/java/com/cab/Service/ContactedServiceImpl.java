package com.cab.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cab.Model.Contact;
import com.cab.Repositary.ContactRepository;

@Service
public class ContactedServiceImpl {

    @Value("${spring.mail.username}")
    private String from;

    @Value("${spring.mail.password}")
    private String password;

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private OTPGenerator optservice;

    public void contact(Contact details) {
        // Check if the email is already contacted
        if (contactRepository.existsByEmail(details.getEmail())) {
            System.out.println("Already Contacted !! .");
            return;
        }

        // Save contact details to the database
        Contact contact = new Contact();
        contact.setEmail(details.getEmail());
        contact.setFullname(details.getFullname());
        contact.setMessage(details.getMessage());
        contactRepository.save(contact);

        // Prepare the email content
        StringBuilder emailContent = new StringBuilder();
        emailContent.append("<html><body>")
                    .append("<h2>New Contact Information</h2>")
                    .append("<p><strong>Full Name:</strong> ").append(details.getFullname()).append("</p>")
                    .append("<p><strong>Email:</strong> ").append(details.getEmail()).append("</p>")
                    .append("<p><strong>Message:</strong> ").append(details.getMessage()).append("</p>")
				/* .append("<br/><p>Thank you for contacting us!</p>") */
                    .append("<br/><p>--</p>")
                    .append("<p>Thanks & Regards,</p>")
                    .append("<p><strong>HR Department | WEBLABS GROUP</strong></p>")
                    .append("<p>Telephone: +91 9701999033</p>")
                    .append("<p>Email: HR@weblabstech.com</p>")
                    .append("<p>Website: <a href='https://www.weblabstech.com'>www.weblabstech.com</a></p>")
                    .append("</body></html>");

        // Send the email with the contact details
        optservice.sendEmailHtmlType("sharath.weblabs@gmail.com", "Contacted Successfully!", emailContent.toString());
    }
}
