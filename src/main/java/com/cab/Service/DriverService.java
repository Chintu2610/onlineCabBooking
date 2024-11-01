package com.cab.Service;

import java.util.List;

import com.cab.Exception.CurrentUserSessionException;
import com.cab.Exception.CustomerException;
import com.cab.Exception.DriverException;
import com.cab.Model.Customer;
import com.cab.Model.Driver;
import com.cab.Model.DriverEarnings;
import com.cab.Model.TripBookingDTO;

public interface DriverService {

    Driver insertDriver(Driver driver)throws DriverException;
	
	Driver updateDriver(Driver driver,String uuid, String driverId)throws DriverException,CurrentUserSessionException;
	
	Driver deleteDriver(Integer driverId, String uuid)throws DriverException,CurrentUserSessionException;
	
	List<Driver> viewBestDriver(String uuid)throws DriverException,CurrentUserSessionException;
	
	Driver viewDriver(Integer driverId,String uuid)throws DriverException,CurrentUserSessionException;
	List<Driver> viewAllDriver(String uuid);
	
	Driver GetDriverData(String username, String uuid) throws CustomerException, CurrentUserSessionException;

	DriverEarnings GetDriverEarnings(String driverid, String uuid) throws CustomerException, CurrentUserSessionException;

	
	List<TripBookingDTO> getDailyTransactions(String driverid, String uuid) throws CustomerException, CurrentUserSessionException ;

	List<TripBookingDTO> getWeeklyTransactions(String driverid, String uuid) throws CustomerException, CurrentUserSessionException ;

	List<TripBookingDTO> getMonthlyTransactions(String driverid, String uuid) throws CustomerException, CurrentUserSessionException ;

	List<TripBookingDTO> getTotalTransactions(String driverid, String uuid) throws CustomerException, CurrentUserSessionException ;
	
	
	
}
