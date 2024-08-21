package com.cab.Service;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cab.Exception.CurrentUserSessionException;
import com.cab.Exception.CustomerException;
import com.cab.Exception.DriverException;
import com.cab.Exception.VendorException;
import com.cab.Model.Admin;
import com.cab.Model.CurrentUserSession;
import com.cab.Model.Customer;
import com.cab.Model.Driver;
import com.cab.Model.TripBooking;
import com.cab.Repositary.AdminRepo;
import com.cab.Repositary.CurrentUserSessionRepo;
import com.cab.Repositary.CustomerRepo;
import com.cab.Repositary.DriverRepo;
import com.cab.Repositary.TripBookingRepo;

@Service
public class VendorServiceImpl implements VendorService{
	@Autowired
	private AdminRepo admnRepo;
	@Autowired
	private CurrentUserSessionRepo currRepo;
	@Override
	public List<Admin> viewAllVendor(String uuid) {
		Optional<CurrentUserSession> validCustomer = currRepo.findByUuidAndRole(uuid);
		
		if (validCustomer.isPresent()) {
		
		List<Admin> allVendor= admnRepo.getAllVendor();
		return allVendor;
		}else
		{
			return null;
		}
	}
	@Override
	public Admin viewVendor(Integer vendorId, String uuid) throws VendorException, CurrentUserSessionException {
		Optional<CurrentUserSession> validCustomer = currRepo.findByUuid(uuid);
		if(validCustomer.isPresent()) {
			Optional<Admin> admin = admnRepo.findById(vendorId);
			if(admin.isPresent()) {
				return admin.get();
			}
			else {
				throw new VendorException("Driver not found with this Credentials");
			}
		}
		else {
			throw new CurrentUserSessionException("User is Not Logged In");
		}
	}
	@Override
	public Admin updateVendor(Admin admin, String uuid) throws VendorException, CurrentUserSessionException {
		// TODO Auto-generated method stub
			
			Optional<CurrentUserSession> validCustomer = currRepo.findByUuid(uuid);
			if(validCustomer.isPresent()) {
				Optional<Admin> adn = admnRepo.findById(admin.getAdminId());
				if(adn.isPresent()) {
					Admin updatingAdmin = adn.get();
					updatingAdmin.setAddress(admin.getAddress());
					updatingAdmin.setEmail(admin.getEmail());
					updatingAdmin.setMobileNumber(admin.getMobileNumber());
					
					updatingAdmin.setUserName(admin.getUserName());
					
					
					 return admnRepo.save(updatingAdmin);
				}
				else {
					throw new VendorException("Vendor not found with this Credentials");
				}
			}
			else {
				throw new CurrentUserSessionException("User is Not Logged In");
			}
		
		
	}
	@Override
	public Admin deleteVendor(Integer vendorId, String uuid) throws VendorException, CurrentUserSessionException {
		
		Optional<CurrentUserSession> validCustomer = currRepo.findByUuid(uuid);
		if(validCustomer.isPresent()) {
			Optional<Admin> admn = admnRepo.findById(vendorId);
			if(admn.isPresent()) {
				Admin updatingVendor = admn.get();
//				List<TripBooking> allTrips= updatingdriver.getTrips();
//				if (allTrips != null && !allTrips.isEmpty()) {
//				    tripbookingRepo.deleteAll(allTrips);
//				}
				admnRepo.delete(updatingVendor);
				return updatingVendor;
			}
			else {
				throw new VendorException("Vendor not found with this Credentials");
			}
		}
		else {
			throw new CurrentUserSessionException("User is Not Logged In");
		}
	}

}

	

	
	

