package com.cab.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cab.Model.Customer;
import com.cab.Repositary.CustomerRepo;

@Service
public class ChangePasswordService {

    @Autowired
    CustomerRepo repository;
// Add URL mapping to handle POST requests
    public boolean changePassword(String email, String newPassword) {
        // Retrieve the list of users by username
        Optional<Customer> userOptional = repository.findByEmail(email);
        
        // If no users found, return false indicating password change failure
        if (userOptional.isEmpty()) {
            return false;
        }
        
        // Since username is unique, there should be only one user in the list
        // Set the new password
        Customer user = userOptional.get();
        user.setPassword(newPassword);
        // Save the updated user entity
        repository.save(user);

        // Return true indicating password change success
        return true;
    }


}
