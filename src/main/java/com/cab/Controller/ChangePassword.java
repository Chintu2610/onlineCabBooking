package com.cab.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cab.Model.Customer;
import com.cab.Service.ChangePasswordService;


@CrossOrigin
@RestController
public class ChangePassword {
	@Autowired
    private  ChangePasswordService changepass;

    public ChangePassword(ChangePasswordService changepass) {
        this.changepass = changepass;
    }
    
    
    
    @PostMapping("/ChangePasswords")
    public ResponseEntity<Void> changePassword(@RequestParam String email,@RequestParam String newPassword) {
    	
        // Assuming changepass.changePassword(email, oldPassword, newPassword) method changes the password
        boolean passwordChanged = changepass.changePassword(email, newPassword);
        if(passwordChanged)
        {
        	return ResponseEntity.ok().build();
        }else
        {
        	return ResponseEntity.notFound().build();
        }
        
    }

}
