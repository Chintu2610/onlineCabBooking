package com.cab.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cab.Exception.CabException;
import com.cab.Exception.CurrentUserSessionException;
import com.cab.Exception.DriverException;
import com.cab.Exception.TripBookingException;
import com.cab.Model.Cab;
import com.cab.Model.RatingRequest;
import com.cab.Model.Report;
import com.cab.Model.ReportRequest;
import com.cab.Model.TripBooking;
import com.cab.Model.TripBookingDTO;
import com.cab.Service.TripBookingService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/tripBooking")
public class TripController {

	@Autowired
	private TripBookingService tripBookingService;
	
	
	@GetMapping("/searchCab")
	public ResponseEntity<List<Cab>> searchByPickupLocation(@RequestParam("pickUpLocation") String pickUpLocation, @RequestParam("uuid") String uuid) throws TripBookingException, CurrentUserSessionException{
		return new ResponseEntity<List<Cab>>(tripBookingService.searchByLocation(pickUpLocation, uuid),HttpStatus.OK);
	}
	
	@PostMapping("/BookRequest")
	public ResponseEntity<String> BookRequest(@RequestParam("cabId") Integer cabId, @RequestBody TripBooking tripBooking, @RequestParam("uuid") String uuid ) throws TripBookingException, CabException, CurrentUserSessionException{
		return new ResponseEntity<String>(tripBookingService.BookRequest(cabId, tripBooking, uuid),HttpStatus.OK);
	}
	
	@PutMapping("/AssignDriverByAdmin")
	public ResponseEntity<TripBooking> AssignDriverByAdmin(@RequestParam("TripBookingId") Integer TripBookingId,@RequestParam("uuid") String uuid) throws TripBookingException, CabException, CurrentUserSessionException{
		return new ResponseEntity<TripBooking>(tripBookingService.AssignDriverByAdmin(TripBookingId, uuid),HttpStatus.OK);
	}
	
	@GetMapping("/viewBookingbyId")
	public ResponseEntity<TripBookingDTO> viewBookingbyId(@RequestParam("TripBookingId") Integer TripBookingId,@RequestParam("uuid") String uuid) throws TripBookingException, CabException, CurrentUserSessionException{
		return new ResponseEntity<TripBookingDTO>(tripBookingService.viewBookingById(TripBookingId, uuid),HttpStatus.OK);
	}
	
	@GetMapping("/markCompleteTrip")
	public ResponseEntity<String>  markCompleteTrip(@RequestParam("TripBookingId") Integer TripBookingId,@RequestParam("uuid") String uuid) throws TripBookingException, CurrentUserSessionException{
		return new ResponseEntity<String>(tripBookingService.MarkTripAsCompleted(TripBookingId, uuid),HttpStatus.OK);
	}
	@GetMapping("/handleAcceptDeclineTrip")
	public ResponseEntity<String>  handleAcceptDeclineTrip(@RequestParam("TripBookingId") Integer TripBookingId,@RequestParam("uuid") String uuid,@RequestParam("status") String status) throws TripBookingException, CurrentUserSessionException{
		return new ResponseEntity<String>(tripBookingService.handleAcceptDeclineTrip(TripBookingId, uuid,status),HttpStatus.OK);
	}
	@GetMapping("/cancelTrip")
	public ResponseEntity<String>  cancelTrip(@RequestParam("TripBookingId") Integer TripBookingId,@RequestParam("uuid") String uuid) throws TripBookingException, CurrentUserSessionException{
		return new ResponseEntity<String>(tripBookingService.cancelTrip(TripBookingId, uuid),HttpStatus.OK);
	}
	@PostMapping("/submitRating")
	public ResponseEntity<String>  submitRating(@RequestParam("uuid") String uuid,@RequestBody RatingRequest rating) throws TripBookingException, CurrentUserSessionException,DriverException{
		return new ResponseEntity<String>(tripBookingService.submitRating(rating, uuid),HttpStatus.OK);
	}
	@PostMapping("/submitReport")
	public ResponseEntity<String>  submitReport(@RequestParam("uuid") String uuid,@RequestBody ReportRequest report) throws TripBookingException, CurrentUserSessionException,DriverException{
		return new ResponseEntity<String>(tripBookingService.submitReport(report, uuid),HttpStatus.OK);
	}
	@GetMapping("/viewRatingDriverWise")
	public ResponseEntity<List<TripBooking>> viewRatingDriverWise(@RequestParam("driverId") int driverId, @RequestParam("uuid") String uuid) throws TripBookingException, CurrentUserSessionException{
		return new ResponseEntity<List<TripBooking>>(tripBookingService.viewRatingDriverWise(driverId, uuid),HttpStatus.OK);
	}
}

