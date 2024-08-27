package com.cab.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cab.Model.Admin;
import com.cab.Model.Customer;
import com.cab.Model.Driver;
import com.cab.Repositary.AdminRepo;
import com.cab.Repositary.CustomerRepo;
import com.cab.Repositary.DriverRepo;
import com.cab.Repositary.OTPDetailsRepository;

@Service
public class ForgotPasswordService {
	@Autowired
	CustomerRepo repository;
	@Autowired
	DriverRepo driverRepo;
	@Autowired
	AdminRepo adminRepo;
	@Autowired
	OTPDetailsRepository myrepo;
	public boolean isEmailExists(String email) {
		// TODO Auto-generated method stub
		Optional<Customer> optionalUser = repository.findByEmail(email);
		Optional<Driver> optionalDriver=driverRepo.findByEmail(email);
		Optional<Admin> optionalAdmin=adminRepo.findByEmail(email);
		if(optionalUser.isPresent() || optionalDriver.isPresent() || optionalAdmin.isPresent())
		{
			return true;
		}else
		{
			return false;
		}
        
		
	}
	
}
