package com.cab.Controller;


import com.cab.Model.Contact;
import com.cab.Service.ContactedServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController()
@RequestMapping("/email")
public class ContactedController {

    @Autowired
    private ContactedServiceImpl contactRepository;

    @PostMapping("/contact")
    public void contact(@RequestBody Contact details) {
    	contactRepository.contact(details);
    }
}


