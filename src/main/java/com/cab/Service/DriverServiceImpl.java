package com.cab.Service;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cab.Exception.CurrentUserSessionException;
import com.cab.Exception.CustomerException;
import com.cab.Exception.DriverException;
import com.cab.Model.CountsForAdminDashboard;
import com.cab.Model.CurrentUserSession;
import com.cab.Model.Customer;
import com.cab.Model.Driver;
import com.cab.Model.DriverEarnings;
import com.cab.Model.TripBooking;
import com.cab.Model.TripBookingDTO;
import com.cab.Repositary.AdminRepo;
import com.cab.Repositary.CurrentUserSessionRepo;
import com.cab.Repositary.CustomerRepo;
import com.cab.Repositary.DriverRepo;
import com.cab.Repositary.TripBookingRepo;

@Service
public class DriverServiceImpl implements DriverService{

	@Autowired
	private DriverRepo driverRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private TripBookingRepo tripbookingRepo;
		
	@Autowired
	private CurrentUserSessionRepo currRepo;
	
	@Autowired
	private DriverRepo drvRepo;
	
	
	@Override
	public Driver insertDriver(Driver driver) throws DriverException {
		
		Optional<Driver> findDriver = driverRepo.findByLicenceNo(driver.getLicenceNo());
		if(findDriver.isPresent()) {
			throw new DriverException("Driver is already registered");
		}
		else {
			if(driver.getUserRole().equalsIgnoreCase("Driver")) {
				return driverRepo.save(driver);
			}
			else {
				throw new DriverException("User is not a Driver");
			}
		}
	}

	@Override
	public Driver updateDriver(Driver driver, String uuid ,String driverId) throws DriverException, CurrentUserSessionException {
		
		Optional<CurrentUserSession> validCustomer = currRepo.findByUuid(uuid);
		if(validCustomer.isPresent()) {
			Optional<Driver> drv = driverRepo.findById(Integer.parseInt(driverId));
			if(drv.isPresent()) {
				Driver updatingdriver = drv.get();
				updatingdriver.setAddress(driver.getAddress());
				updatingdriver.setEmail(driver.getEmail());
				updatingdriver.setMobileNumber(driver.getMobileNumber());
				updatingdriver.setPassword(driver.getPassword());
				updatingdriver.setUserName(driver.getUserName());
				updatingdriver.setLicenceNo(driver.getLicenceNo());
				updatingdriver.setCab(driver.getCab());
				updatingdriver.setCurrLocation(driver.getCurrLocation());
				updatingdriver.setCurrDriverStatus(driver.getCurrDriverStatus());
				 return driverRepo.save(updatingdriver);
			}
			else {
				throw new DriverException("Driver not found with this Credentials");
			}
		}
		else {
			throw new CurrentUserSessionException("User is Not Logged In");
		}
	}

	@Override
	public Driver deleteDriver(Integer driverId, String uuid) throws DriverException, CurrentUserSessionException {
		
		Optional<CurrentUserSession> validCustomer = currRepo.findByUuid(uuid);
		if(validCustomer.isPresent()) {
			Optional<Driver> drv = driverRepo.findById(driverId);
			if(drv.isPresent()) {
				Driver updatingdriver = drv.get();
				List<TripBooking> allTrips= updatingdriver.getTrips();
				if (allTrips != null && !allTrips.isEmpty()) {
				    tripbookingRepo.deleteAll(allTrips);
				}
				driverRepo.delete(updatingdriver);
				return updatingdriver;
			}
			else {
				throw new DriverException("Driver not found with this Credentials");
			}
		}
		else {
			throw new CurrentUserSessionException("User is Not Logged In");
		}
	}

	@Override
	public List<Driver> viewBestDriver(String uuid) throws DriverException, CurrentUserSessionException {
		// TODO Auto-generated method stub
		List<Driver> allDrivers = driverRepo.findAll();
		List<Driver> bestDriver = new ArrayList<>();
		for(Driver d : allDrivers) {
			if(d.getRating()>=4.5) {
				bestDriver.add(d);
			}
		}
		if(bestDriver.isEmpty()) {
//			throw new DriverException("No Best Driver Present");
			return null;
		}
		else {
			Collections.sort(bestDriver,(a,b)-> Float.compare(b.getRating(), a.getRating()));
			return bestDriver;
		}
		
		
	}

	@Override
	public Driver viewDriver(Integer driverId,String uuid) throws DriverException, CurrentUserSessionException {
		// TODO Auto-generated method stub
		Optional<CurrentUserSession> validCustomer = currRepo.findByUuid(uuid);
		if(validCustomer.isPresent()) {
			Optional<Driver> drv = driverRepo.findById(driverId);
			if(drv.isPresent()) {
				return drv.get();
			}
			else {
				throw new DriverException("Driver not found with this Credentials");
			}
		}
		else {
			throw new CurrentUserSessionException("User is Not Logged In");
		}
	}

	@Override
	public List<Driver> viewAllDriver(String uuid) {
		Optional<CurrentUserSession> validCustomer = currRepo.findByUuid(uuid);
		String role=validCustomer.get().getCurrRole();
		String email=validCustomer.get().getEmail();
		if(validCustomer.isPresent() && role.equalsIgnoreCase("admin")) {
		List<Driver> allDrivers= drvRepo.getAllDrivers();
		return allDrivers;
		}else if(validCustomer.isPresent() && role.equalsIgnoreCase("vendor"))
		{
			List<Driver> allDrivers= drvRepo.getAllDrivers();
			List<Driver> filteredDrivers=new ArrayList<>();
			for(Driver drv:allDrivers)
			{
				if(drv.getOwnerEmail().equals(email))
				{
					filteredDrivers.add(drv);
				}
			}
			return filteredDrivers;
		}
		return null;
	}

	@Override
	public Driver GetDriverData(String driverid, String uuid)
			throws CustomerException, CurrentUserSessionException {
			Optional<CurrentUserSession> validCustomer =  currRepo.findByUuid(uuid);
			if(validCustomer.isPresent()) {
				Optional<Driver> cust = driverRepo.findByDriverId(driverid);
				if(cust.isPresent()) {
					 return cust.get();
				}
				else {
					throw new CustomerException("Driver not found with this details");
				}
			}
			else {
				throw new CurrentUserSessionException("Driver is Not Logged In");
			}
		}

	@Override
	public DriverEarnings GetDriverEarnings(String driverid, String uuid)
			throws CustomerException, CurrentUserSessionException {
Optional<CurrentUserSession> validCustomer = currRepo.findByUuid(uuid);		
		if (validCustomer.isPresent()) {
		String role=validCustomer.get().getCurrRole();
		List<Object[]> results=null;			
				 results =driverRepo.GetDriverEarnings(driverid);
				 if (!results.isEmpty()) {
					    Object[] row = results.get(0);
					    DriverEarnings counts = new DriverEarnings();
					    // Handle null values safely by checking each element before casting
					    counts.setTodayEarnings(row[0] != null ? ((Number) row[0]).intValue() : 0);
					    counts.setWeeklyEarnings(row[1] != null ? ((Number) row[1]).intValue() : 0);
					    counts.setMonthlyEarnings(row[2] != null ? ((Number) row[2]).intValue() : 0);
					    counts.setTotalEarnings(row[3] != null ? ((Number) row[3]).intValue() : 0);
					    return counts;
					}
		        return null; // Or handle this case as needed}
		}
		else {
			throw new CurrentUserSessionException("Admin is Not Logged In");
		}
	}
	@Override
	public List<TripBookingDTO> getDailyTransactions(String driverid, String uuid) throws CustomerException, CurrentUserSessionException  {
Optional<CurrentUserSession> validCustomer = currRepo.findByUuid(uuid);
		
		
			if(validCustomer.isPresent()) {
				Optional<Driver> cust = driverRepo.findByDriverId(driverid);
				if(cust.isPresent()) {
					List<TripBooking> transactions=tripbookingRepo.findDailyTransactions(Integer.parseInt(driverid));
					 List<TripBookingDTO> tripBookingDTOs = new ArrayList<>();
				        for (TripBooking trip : transactions) {
				            TripBookingDTO dto = new TripBookingDTO();
				            dto.setToDateTime(trip.getToDateTime());
				            dto.setPrice(Double.parseDouble(trip.getPrice()));
				            tripBookingDTOs.add(dto);
				        }
				        return tripBookingDTOs;
				}
				else {
					throw new CustomerException("Driver not found with this details");
				}
		
			}
			
			
			else {
			throw new CurrentUserSessionException("Admin is Not Logged In");
		}
			
	}

	@Override
	public List<TripBookingDTO> getWeeklyTransactions(String driverid, String uuid) throws CustomerException, CurrentUserSessionException  {
		Optional<CurrentUserSession> validCustomer = currRepo.findByUuid(uuid);
		if(validCustomer.isPresent()) {
			Optional<Driver> cust = driverRepo.findByDriverId(driverid);
			if(cust.isPresent()) {
				
				List<TripBooking> transactions=tripbookingRepo.findWeeklyTransactions(Integer.parseInt(driverid));
				 List<TripBookingDTO> tripBookingDTOs = new ArrayList<>();
			        for (TripBooking trip : transactions) {
			            TripBookingDTO dto = new TripBookingDTO();
			            dto.setToDateTime(trip.getToDateTime());
			            dto.setPrice(Double.parseDouble(trip.getPrice()));
			            tripBookingDTOs.add(dto);
			        }
			        return tripBookingDTOs;
			}
			else {
				throw new CustomerException("Driver not found with this details");
			}
	
		}
		
		
		else {
		throw new CurrentUserSessionException("Admin is Not Logged In");
	}
		
	}
	  

	@Override
	public List<TripBookingDTO> getMonthlyTransactions(String driverid, String uuid) throws CustomerException, CurrentUserSessionException  {
		Optional<CurrentUserSession> validCustomer = currRepo.findByUuid(uuid);
		if(validCustomer.isPresent()) {
			Optional<Driver> cust = driverRepo.findByDriverId(driverid);
			if(cust.isPresent()) {
				List<TripBooking> transactions=tripbookingRepo.findMonthlyTransactions(Integer.parseInt(driverid));
				List<TripBookingDTO> tripBookingDTOs = new ArrayList<>();
		        for (TripBooking trip : transactions) {
		            TripBookingDTO dto = new TripBookingDTO();
		            dto.setToDateTime(trip.getToDateTime());
		            dto.setPrice(Double.parseDouble(trip.getPrice()));
		            tripBookingDTOs.add(dto);
		        }
		        return tripBookingDTOs;
			}
			else {
				throw new CustomerException("Driver not found with this details");
			}
	
		}
		else {
		throw new CurrentUserSessionException("Admin is Not Logged In");
	}
		
	}

	@Override
	public List<TripBookingDTO> getTotalTransactions(String driverid, String uuid) throws CustomerException, CurrentUserSessionException  {
		Optional<CurrentUserSession> validCustomer = currRepo.findByUuid(uuid);
		if(validCustomer.isPresent()) {
			Optional<Driver> cust = driverRepo.findByDriverId(driverid);
			if(cust.isPresent()) {
				List<TripBooking> transactions=tripbookingRepo.findTotalTransactions(Integer.parseInt(driverid));
				List<TripBookingDTO> tripBookingDTOs = new ArrayList<>();
		        for (TripBooking trip : transactions) {
		            TripBookingDTO dto = new TripBookingDTO();
		            dto.setToDateTime(trip.getToDateTime());
		            dto.setPrice(Double.parseDouble(trip.getPrice()));
		            tripBookingDTOs.add(dto);
		        }
		        return tripBookingDTOs;
			}
			else {
				throw new CustomerException("Driver not found with this details");
			}
	
		}
		
		
		else {
		throw new CurrentUserSessionException("Admin is Not Logged In");
	}
		
	}

	
	}

	

	
	

