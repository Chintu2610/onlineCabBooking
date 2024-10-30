package com.cab.Service;

import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cab.Exception.AdminException;
import com.cab.Exception.CurrentUserSessionException;
import com.cab.Exception.CustomerException;
import com.cab.Model.Admin;
import com.cab.Model.CurrentUserSession;
import com.cab.Model.Customer;
import com.cab.Model.Driver;
import com.cab.Model.UserLoginDTO;
import com.cab.Repositary.AdminRepo;
import com.cab.Repositary.CurrentUserSessionRepo;
import com.cab.Repositary.CustomerRepo;
import com.cab.Repositary.DriverRepo;

@Service
public class UserLoginServiceimpl implements UserLoginService {

	@Autowired
	private CustomerRepo customerRepo;

	@Autowired
	private AdminRepo adminRepo;

	@Autowired
	private CurrentUserSessionRepo currRepo;
	@Autowired
	private DriverRepo driverRepo;
	 private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public CurrentUserSession login(UserLoginDTO dto) throws CustomerException, AdminException {		
			Optional<Admin> findAdmin = adminRepo.findByEmail(dto.getEmail());
			Optional<Customer> findCustomer = customerRepo.findByEmail(dto.getEmail());
			Optional<Driver> findDriver = driverRepo.findByEmail(dto.getEmail());
			if(findAdmin.isPresent() && findCustomer.isEmpty() && findDriver.isEmpty()) {
				Admin currAdmin = findAdmin.get();
				Optional<CurrentUserSession> validAdminSession = currRepo.findById(currAdmin.getAdminId());
				if(validAdminSession.isPresent()) {
					return validAdminSession.get();
					//throw new AdminException("Admin is currently Login Please Logout and then try");
				}
				else {
					//if(currAdmin.getPassword().equals(dto.getPassword())) {
					if(checkPassword(dto.getPassword(),currAdmin.getPassword())&& currAdmin.getApprovalStatus().equalsIgnoreCase("approved")) {
						String key = RandomStringUtils.randomAlphanumeric(6);
						CurrentUserSession curr = new CurrentUserSession();
						curr.setUuid(key);
						curr.setCurrRole(currAdmin.getUserRole());
						curr.setCurrStatus("Login Successfull");
						curr.setCurrUserId(currAdmin.getAdminId());
						curr.setEmail(currAdmin.getEmail());
						return currRepo.save(curr);
					}
					else {
						throw new AdminException("Please Enter the correct Password");
					}
				}
			}
			else if(findAdmin.isEmpty() && findCustomer.isPresent() && findDriver.isEmpty()){
					Customer currCustomer = findCustomer.get();
					Optional<CurrentUserSession> validCustomerSession = currRepo.findById(currCustomer.getCustomerId());
					if(validCustomerSession.isPresent()) {
						//throw new CustomerException("Customer is currently Login Please Logout and then try");
						return validCustomerSession.get();
					}
					else {
						//if(currCustomer.getPassword().equals(dto.getPassword())) {
						if(checkPassword(dto.getPassword(),currCustomer.getPassword())) {
							String key = RandomStringUtils.randomAlphanumeric(6);
							CurrentUserSession curr = new CurrentUserSession();
							curr.setUuid(key);
							curr.setCurrRole("Customer");
							curr.setCurrStatus("Login Successfull");
							curr.setCurrUserId(currCustomer.getCustomerId());
							curr.setEmail(currCustomer.getEmail());
							return currRepo.save(curr);
						}
						else {
							throw new CustomerException("Please Enter the correct Password");
						}
					}
				} else if(findAdmin.isEmpty() && findCustomer.isEmpty() && findDriver.isPresent())
				{
					Driver currDriver = findDriver.get();
					Optional<CurrentUserSession> validDriverSession = currRepo.findById(currDriver.getDriverId());
					if(validDriverSession.isPresent()) {
						//throw new CustomerException("Driver is currently Login Please Logout and then try");
						return validDriverSession.get();
					}
					else  {
						//if(currDriver.getPassword().equals(dto.getPassword())) {
						if(checkPassword(dto.getPassword(),currDriver.getPassword())) {
							String key = RandomStringUtils.randomAlphanumeric(6);
							CurrentUserSession curr = new CurrentUserSession();
							curr.setUuid(key);
							curr.setCurrRole("Driver");
							curr.setCurrStatus("Login Successfull");
							curr.setCurrUserId(currDriver.getDriverId());
							curr.setEmail(currDriver.getEmail());
							return currRepo.save(curr);
						}
						else {
							throw new CustomerException("Please Enter the correct Password");
						}
					}
				}
			else {
				throw new CustomerException("User is Not Registered");
			}
		}
	public boolean checkPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
	@Override
	public String LogOut(String uuid) throws CurrentUserSessionException {
		// TODO Auto-generated method stub
		Optional<CurrentUserSession> validAdminOrCustomer = currRepo.findByUuid(uuid);
		if (validAdminOrCustomer.isPresent()) {

			currRepo.delete(validAdminOrCustomer.get());
			return "User Logged Out Successfully";

		} else {
			throw new CurrentUserSessionException("User Not Logged In with this Credentials");
		}
	}

}
