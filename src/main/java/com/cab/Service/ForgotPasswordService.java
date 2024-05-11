package com.cab.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cab.Model.Customer;
import com.cab.Repositary.CustomerRepo;
import com.cab.Repositary.OTPDetailsRepository;

@Service
public class ForgotPasswordService {
	@Autowired
	CustomerRepo repository;
	@Autowired
	OTPDetailsRepository myrepo;
	public boolean isEmailExists(String email) {
		// TODO Auto-generated method stub
		Optional<Customer> optionalUser = repository.findByEmail(email);
        return optionalUser.isPresent();
		
	}
	
}
