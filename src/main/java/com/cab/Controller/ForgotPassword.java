package com.cab.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cab.Model.Customer;
import com.cab.Service.ForgotPasswordService;
import com.cab.Service.OTPGenerator;
import com.cab.Service.OTPService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@CrossOrigin
@RestController
public class ForgotPassword {
	@Autowired
	ForgotPasswordService forgotpasswordservice;
	
	@Autowired
	OTPService oTPService;
	@Autowired
	OTPGenerator otpGenoratorsrv;
	
	@PostMapping("/PasswordReset")
    public ResponseEntity<Void> resetPassword(@RequestParam String toEmail) {    	
    	
    	 // Assuming the parameter name is "email"
		if (forgotpasswordservice.isEmailExists(toEmail)) {
			
			String otp = otpGenoratorsrv.sendOTPEmail(toEmail);
			// Store the OTP in the session to verify it later
//			request.getSession().setAttribute("otp", otp);
//			request.getSession().setAttribute("email", toEmail);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build(); 
		}
    	
    }
	@RequestMapping(value = "/ValidateOtp", method = RequestMethod.POST)
    public String ValidateOtp(@RequestParam String otp) {  
//		int enteredOTP = Integer.parseInt(request.getParameter("otp"));
//		int storedOTP =oTPService.StoredOpt(otp);
        return "hi";
    }
}
