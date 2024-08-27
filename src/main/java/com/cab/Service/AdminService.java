package com.cab.Service;



import java.util.List;

import com.cab.Exception.AdminException;
import com.cab.Exception.CurrentUserSessionException;
import com.cab.Exception.CustomerException;
import com.cab.Exception.TripBookingException;
import com.cab.Model.Admin;
import com.cab.Model.Cab;
import com.cab.Model.CountsForAdminDashboard;
import com.cab.Model.Customer;
import com.cab.Model.TripBooking;


public interface AdminService {

	Admin insertAdmin(Admin admin,String currRole) throws AdminException;
	
    Admin updateAdmin(Admin admin,String uuid) throws AdminException,CurrentUserSessionException;
	
    Admin deleteAdmin(Integer adminId,String uuid) throws AdminException,CurrentUserSessionException;
    
    List<TripBooking> getAllTrips(String uuid)throws AdminException, TripBookingException, CurrentUserSessionException;
	  
    List<TripBooking> getTripsCabwise(String carType, String uuid)throws TripBookingException, CurrentUserSessionException;
    
    List<TripBooking> getTripsCustomerwise(Integer customerId, String uuid)throws TripBookingException,CustomerException, CurrentUserSessionException;
    
    List<TripBooking> getAllTripsForDays(Integer customerId, String fromDateTime, String toDateTime, String uuid)throws TripBookingException,CustomerException, CurrentUserSessionException;

	Admin viewAdminProfile(Integer adminId, String uuid);

	List<Admin> getAllAdmin(String email, String uuid) throws CurrentUserSessionException;
	
	CountsForAdminDashboard getCountsForAdminDashboard( String uuid) throws  CurrentUserSessionException;

	List<TripBooking> getTripsDriverwise(Integer driverId, String uuid) throws TripBookingException, CustomerException, CurrentUserSessionException;
	
}
