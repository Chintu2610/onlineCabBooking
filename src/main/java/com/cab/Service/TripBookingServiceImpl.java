package com.cab.Service;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cab.Exception.CabException;
import com.cab.Exception.CurrentUserSessionException;
import com.cab.Exception.DriverException;
import com.cab.Exception.TripBookingException;
import com.cab.Model.Cab;
import com.cab.Model.CurrentUserSession;
import com.cab.Model.Customer;
import com.cab.Model.Driver;
import com.cab.Model.RatingRequest;
import com.cab.Model.TripBooking;
import com.cab.Model.TripBookingDTO;
import com.cab.Repositary.CabRepo;
import com.cab.Repositary.CurrentUserSessionRepo;
import com.cab.Repositary.CustomerRepo;
import com.cab.Repositary.DriverRepo;
import com.cab.Repositary.TripBookingRepo;

@Service
public class TripBookingServiceImpl implements TripBookingService{

	
	@Autowired
	private TripBookingRepo tripBookingRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private CabRepo cabRepo;
	
	@Autowired
	private CurrentUserSessionRepo currRepo;
	
	@Autowired
	private DriverRepo driverRepo;
	
	
	
	@Override
	public List<Cab> searchByLocation(String pickUpLocation, String uuid)
			throws TripBookingException, CurrentUserSessionException {
		Optional<CurrentUserSession> validUser = currRepo.findByUuid(uuid);
		if(validUser.isPresent()) {
			List<Cab> allCab = cabRepo.findAll();
		    List<Cab> availableCab = new ArrayList<>();
		    for(Cab cab : allCab) {
		    	if(cab.getCabCurrStatus().equalsIgnoreCase("Available") && cab.getCurrLocation().equalsIgnoreCase(pickUpLocation)) {
		    		availableCab.add(cab);
		    	}
		    }
		    if(availableCab.isEmpty()) {
		    	throw new TripBookingException("No Cab Available in this Location");
		    }
		    else {
		    	return availableCab;
		    }
		}
		else {
			throw new CurrentUserSessionException("User Not Login");
		}
	}


	@Override
	public String BookRequest(Integer cabId, TripBooking tripBooking, String uuid)
	        throws TripBookingException, CabException, CurrentUserSessionException {
	    Optional<CurrentUserSession> validUser = currRepo.findByUuid(uuid);
	    if (validUser.isPresent()) {
	        CurrentUserSession currUser = validUser.get();
	        Optional<Customer> cust = customerRepo.findById(currUser.getCurrUserId());
	        if (!cust.isPresent()) {
	        	throw new CurrentUserSessionException("User is Not Login");
	        }
	        Customer customer = cust.get();

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
	        LocalDateTime fromDT = LocalDateTime.parse(tripBooking.getFromDateTime(), formatter);
	        LocalDateTime toDT = LocalDateTime.parse(tripBooking.getToDateTime(), formatter);

	        List<TripBooking> allTripByCustomer = customer.getTripBooking();
	        if (isTripOverlap(tripBooking, allTripByCustomer)) {
	            return ("You have already booked another Trip at the same Time");
	        } else {
	            Optional<Cab> addCab = cabRepo.findById(cabId);
	            if (addCab.isPresent()) {
	                Cab newCab = addCab.get();
	                //if (newCab.getCabCurrStatus().equalsIgnoreCase("Available") &&
	                       // newCab.getCurrLocation().equalsIgnoreCase(tripBooking.getPickupLocation())) {
	                if (newCab.getCabCurrStatus().equalsIgnoreCase("Available") ) {
	                	  
	         	            List<Driver> allDrivers = driverRepo.findByCurrDriverStatus( "Available");
	         	            if (allDrivers.isEmpty()) {
	         	                return ("No driver is available for this trip.");
	         	            } else {
	         	            	boolean flag=false;
	         	            	for(Driver drv:allDrivers)
	         	            	{
	         	            		if(drv.getGender().equals(tripBooking.getPreferredGender()))
	         	            		{
	         	            			Driver assignDriver = drv;
	    	         	                assignDriver.setCurrDriverStatus("Booked");
	    	         	                assignDriver.setCab(newCab);
	    	         	               newCab.setDriver(assignDriver);
	    	         	              newCab.setCabCurrStatus("Booked");
	    	         	                cabRepo.save(newCab);
	    	         	                driverRepo.save(assignDriver);
	    	         	                customerRepo.save(customer);
	    	         	                flag=true;
	    	         	               tripBooking.setCab(newCab);
	    	   	                    tripBooking.setCustomer(customer);
	    	   	                    tripBooking.setDriver(drv);
	    	   	                    tripBooking.setCurrStatus("Pending");
	    	   	                    tripBooking.setFromDateTime(fromDT.toString());
	    	   	                    tripBooking.setToDateTime(toDT.toString());
	    	   	                 tripBooking.setRating(-1);
	    	   	                    TripBooking savedTripBooking = tripBookingRepo.save(tripBooking);	                    
	    	   	                    // Ensure the saved trip booking is correctly added to the customer's list
	    	   	                    allTripByCustomer.add(savedTripBooking);
	    	   	                    customer.setTripBooking(allTripByCustomer);
	    	   	                    customerRepo.save(customer);	                   
	    	   	                    
	    	         	                break;
	         	            		}
	         	            	}
	         	            	if(flag) {
	         	                	         	                
	         	            		return "Cab booked successfully.";        
	                    
	                    
	         	            	}else {
	         	            		return ("No Driver Present with the given preferred gender");
	         	            	}
	         	            }
	                } else {
	                    return ("This Cab is not available currently for location or availability purpose");
	                }
	            } else {
	                return ("No Cab Present with the given Credentials");
	            }
	        }
	    } else {
	        throw new CurrentUserSessionException("User is Not Logged In");
	    }
	}
	public List<Driver> getAvailableDrivers(String pickUpLocation) {
	    return driverRepo.findByCurrLocationAndCurrDriverStatus(pickUpLocation, "available");
	}
	public boolean isTripOverlap(TripBooking newTripBooking, List<TripBooking> existingTrips) {
	    if (newTripBooking.getFromDateTime() == null || newTripBooking.getToDateTime() == null) {
	        return false; 
	    }
	    
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
	    LocalDateTime newTripFromDT = LocalDateTime.parse(newTripBooking.getFromDateTime(), formatter);
	    LocalDateTime newTripToDT = LocalDateTime.parse(newTripBooking.getToDateTime(), formatter);
	    for (TripBooking existingTripBooking : existingTrips) {
	    	String status=existingTripBooking.getCurrStatus();
	        if (existingTripBooking.getFromDateTime() == null || existingTripBooking.getToDateTime() == null) {
	            continue;
	        }
	        LocalDateTime existingTripFromDT = LocalDateTime.parse(existingTripBooking.getFromDateTime(), formatter);
	        LocalDateTime existingTripToDT = LocalDateTime.parse(existingTripBooking.getToDateTime(), formatter);
	        if (newTripFromDT.isBefore(existingTripToDT) && newTripToDT.isAfter(existingTripFromDT) && (status.equalsIgnoreCase("pending") || status.equalsIgnoreCase("accepted"))) {
	            return true;
	        }
	    }    
	    return false;
	}



	@Override
	public TripBooking AssignDriverByAdmin(Integer tripBookingId, String uuid)
	        throws TripBookingException, CabException, CurrentUserSessionException {
	    Optional<CurrentUserSession> validUser = currRepo.findByUuid(uuid);
	    if (validUser.isPresent()) {
	        Optional<TripBooking> optionalTrip = tripBookingRepo.findById(tripBookingId);
	        if (optionalTrip.isPresent()) {
	            TripBooking trip = optionalTrip.get();
	            Customer customer = trip.getCustomer();
	            List<Driver> allDrivers = driverRepo.findByCurrLocationAndCurrDriverStatus(trip.getPickupLocation(), "available");
	            if (allDrivers.isEmpty()) {
	                trip.setCurrStatus("cancelled");
	                tripBookingRepo.save(trip);
	                customer.getTripBooking().forEach(tb -> {
	                    if (tb.getTripBookingId().equals(trip.getTripBookingId())) {
	                        tb.setCurrStatus("cancelled");
	                    }
	                });
	                customerRepo.save(customer);
	                throw new TripBookingException("No driver is available for this trip.");
	            } else {
	                Driver assignDriver = allDrivers.get(0);
	                assignDriver.setCurrDriverStatus("Booked");
	                assignDriver.setCab(trip.getCab());
	                trip.getCab().setDriver(assignDriver);
	                trip.getCab().setCabCurrStatus("Booked");
	                cabRepo.save(trip.getCab());

	                List<TripBooking> allTripByDrv = assignDriver.getTrips();
	                allTripByDrv.add(trip);
	                assignDriver.setTrips(allTripByDrv);

	                trip.setCurrStatus("confirmed");
	                trip.setDriver(assignDriver);

	                customer.getTripBooking().forEach(tb -> {
	                    if (tb.getTripBookingId().equals(trip.getTripBookingId())) {
	                        tb.setCurrStatus("confirmed");
	                        tb.setDriver(assignDriver);
	                    }
	                });

	                tripBookingRepo.save(trip);
	                driverRepo.save(assignDriver);
	                customerRepo.save(customer);
	                return trip;
	            }
	        } else {
	            throw new TripBookingException("No trip is booked with provided tripBookingId.");
	        }
	    } else {
	        throw new CurrentUserSessionException("User is not logged in or is not an admin.");
	    }
	}



	@Override
	public TripBookingDTO viewBookingById(Integer TripBookingId, String uuid)
			throws TripBookingException, CabException, CurrentUserSessionException {
		Optional<CurrentUserSession> validUser = currRepo.findByUuid(uuid);
		if(validUser.isPresent()) {
			Optional<TripBooking> tp = tripBookingRepo.findById(TripBookingId);
			if(tp.isPresent()) {
				TripBooking trip = tp.get();
				TripBookingDTO showTrip = new TripBookingDTO();
				showTrip.setTripBookingId(TripBookingId);
				showTrip.setPickupLocation(trip.getPickupLocation());
				showTrip.setFromDateTime(trip.getFromDateTime());
				showTrip.setDropLocation(trip.getDropLocation());
				showTrip.setToDateTime(trip.getToDateTime());
				showTrip.setDistanceInKm(trip.getDistanceInKm());
				showTrip.setDriverName(trip.getDriver().getUserName());
				showTrip.setLicenceNo(trip.getDriver().getLicenceNo());
				showTrip.setRating(trip.getDriver().getRating());
				showTrip.setCarType(trip.getCab().getCarType());
				showTrip.setCarName(trip.getCab().getCarName());
				showTrip.setCarNumber(trip.getCab().getCarNumber());
				showTrip.setPerKmRate(trip.getCab().getPerKmRate());
				showTrip.setFare(trip.getCab().getPerKmRate() * trip.getDistanceInKm());
				showTrip.setTripStatus(trip.getCurrStatus());
				showTrip.setPrice(Double.parseDouble(trip.getPrice()) );
				showTrip.setDriverId(trip.getDriver().getDriverId());
				return showTrip;
			}
			else {
				throw new TripBookingException("No trip is booked with provided tripBookingId.");
			}
		}
		else {
			throw new CurrentUserSessionException("User is not logged in");
		}
	    
	}


	@Override
	public String MarkTripAsCompleted(Integer TripBookingId, String uuid)
			throws TripBookingException, CurrentUserSessionException {
		Optional<CurrentUserSession> validUser = currRepo.findByUuid(uuid);
		if(validUser.isPresent()) {
			Optional<TripBooking> tp = tripBookingRepo.findById(TripBookingId);
			if(tp.isPresent()) {
				TripBooking trip = tp.get();
				trip.setCurrStatus("Completed");
				tripBookingRepo.save(trip);
				Customer cust = trip.getCustomer();
				List<TripBooking> allTrip = cust.getTripBooking();
				for(TripBooking tb : allTrip) {
					if(tb.getTripBookingId() == trip.getTripBookingId()) {
						tb.setCurrStatus("Completed");
					}
				}
				customerRepo.save(cust);
				trip.getCab().setCabCurrStatus("AVAILABLE");
				cabRepo.save(trip.getCab());
				trip.getDriver().setCurrDriverStatus("Available");
				trip.getDriver().setCab(null);
			    trip.getCab().setDriver(null);
				driverRepo.save(trip.getDriver());
				return "Thank you your Trip has been Completed";
			}
			else {
				throw new TripBookingException("No trip is booked with provided tripBookingId.");
			}
		}
		else {
			throw new CurrentUserSessionException("User is not logged in");
		}
	}


	@Override
	public String cancelTrip(Integer TripBookingId, String uuid)
			throws TripBookingException, CurrentUserSessionException {
		Optional<CurrentUserSession> validUser = currRepo.findByUuid(uuid);
		if(validUser.isPresent()) {
			Optional<TripBooking> tp = tripBookingRepo.findById(TripBookingId);
			if(tp.isPresent()) {
				TripBooking trip = tp.get();
				trip.setCurrStatus("Cancelled");
				tripBookingRepo.save(trip);
				Customer cust = trip.getCustomer();
				List<TripBooking> allTrip = cust.getTripBooking();
				for(TripBooking tb : allTrip) {
					if(tb.getTripBookingId() == trip.getTripBookingId()) {
						tb.setCurrStatus("Cancelled");
					}
				}
				customerRepo.save(cust);
				trip.getCab().setCabCurrStatus("AVAILABLE");
				cabRepo.save(trip.getCab());
				trip.getDriver().setCurrDriverStatus("Available");
				trip.getDriver().setCab(null);
			    trip.getCab().setDriver(null);
				driverRepo.save(trip.getDriver());
				return "your trip is successfully cancelled.";
			}
			else {
				throw new TripBookingException("No trip is booked with provided tripBookingId.");
			}
		}
		else {
			throw new CurrentUserSessionException("User is not logged in");
		}
	}


	@Override
	public String submitRating(RatingRequest rating, String uuid) throws DriverException {
		Optional<CurrentUserSession> validUser = currRepo.findByUuid(uuid);
		if(validUser.isPresent()) {
			Optional<TripBooking> tripBookingopn=tripBookingRepo.findByTripBookingId(rating.getTripBookingId());
			if(tripBookingopn.isPresent())
			{
				TripBooking tripBooking=tripBookingopn.get();
				tripBooking.setRating(rating.getRating());
				tripBooking.setFeedBack(rating.getFeedBack());
				
				tripBookingRepo.save(tripBooking);
			}else
			{
				return "No such trip booking is there.";
			}
			
		}else {
			return "User is not logged in";
		}
		
		return null;
	}


	@Override
	public List<TripBooking> viewRatingDriverWise(int driverId, String uuid) throws TripBookingException, CurrentUserSessionException {
		// TODO Auto-generated method stub
		Optional<CurrentUserSession> validUser = currRepo.findByUuid(uuid);
		if(validUser.isPresent()) {
			List<TripBooking> alltrips= tripBookingRepo.findAll();
			List<TripBooking> tempTrips=new ArrayList<TripBooking>();
			for(TripBooking trip:alltrips)
			{
				if(trip.getDriver().getDriverId()==driverId)
				{
					tempTrips.add(trip);
				}
			}
			return tempTrips;
		}else {
			throw new CurrentUserSessionException("User is not logged in");
		}
	}
	@Override
	public String handleAcceptDeclineTrip(Integer tripBookingId, String uuid,String status) throws TripBookingException,CurrentUserSessionException {
		Optional<CurrentUserSession> validUser = currRepo.findByUuid(uuid);
		if(validUser.isPresent()) {
			Optional<TripBooking> tp = tripBookingRepo.findById(tripBookingId);
			if(tp.isPresent()) {
				TripBooking trip = tp.get();
				trip.setCurrStatus(status);
				tripBookingRepo.save(trip);
				Customer cust = trip.getCustomer();
				List<TripBooking> allTrip = cust.getTripBooking();
				for(TripBooking tb : allTrip) {
					if(tb.getTripBookingId() == trip.getTripBookingId()) {
						tb.setCurrStatus(status);
					}
				}
				customerRepo.save(cust);
				if(status.equals("Declined")) {
				trip.getCab().setCabCurrStatus("Available");
				cabRepo.save(trip.getCab());
				trip.getDriver().setCurrDriverStatus("Available");
				trip.getDriver().setCab(null);
			    trip.getCab().setDriver(null);
				driverRepo.save(trip.getDriver());
				return "Trip Declined By You.";
				}
				return "Trip Accepted.";
			}
			else {
				throw new TripBookingException("No trip is booked with provided tripBookingId.");
			}
		}
		else {
			throw new CurrentUserSessionException("User is not logged in");
		}
	}
	
	
	
	
	

	

}




