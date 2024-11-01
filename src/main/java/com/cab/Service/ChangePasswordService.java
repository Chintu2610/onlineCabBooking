package com.cab.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cab.Model.Admin;
import com.cab.Model.Customer;
import com.cab.Model.Driver;
import com.cab.Repositary.AdminRepo;
import com.cab.Repositary.CustomerRepo;
import com.cab.Repositary.DriverRepo;

@Service
public class ChangePasswordService {

    @Autowired
    CustomerRepo repository;
    @Autowired
	DriverRepo driverRepo;
	@Autowired
	AdminRepo adminRepo;
	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
// Add URL mapping to handle POST requests
    public boolean changePassword(String email, String newPassword) {
        // Retrieve the list of users by username
        Optional<Customer> userOptional = repository.findByEmail(email);
        Optional<Driver> optionalDriver=driverRepo.findByEmail(email);
		Optional<Admin> optionalAdmin=adminRepo.findByEmail(email);
		String encryptedPassword = passwordEncoder.encode(newPassword);
        // If no users found, return false indicating password change failure
		if(userOptional.isPresent() )
		{
			Customer user = userOptional.get();
			
    		
	        user.setPassword(encryptedPassword);
	        repository.save(user);
			return true;
		}
		
		if(optionalDriver.isPresent() )
		{
			Driver driver = optionalDriver.get();
			driver.setPassword(encryptedPassword);
			driverRepo.save(driver);
			return true;
		}
		
		if(optionalAdmin.isPresent() )
		{
			Admin admin = optionalAdmin.get();
			admin.setPassword(encryptedPassword);
			adminRepo.save(admin);
			return true;
		}
		
 
        return false;
    }


}
