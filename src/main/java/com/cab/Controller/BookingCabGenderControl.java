package com.cab.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cab.Exception.AdminException;
import com.cab.Model.BookingCabGender;
import com.cab.Service.BookingCabGenderService;
import com.cab.Exception.CurrentUserSessionException;

@RestController
@RequestMapping("/BookingCabGender")
public class BookingCabGenderControl {

    @Autowired
    private BookingCabGenderService booking;
    
    @PostMapping("/book")
    public ResponseEntity<String> bookCabForGender(@RequestBody BookingCabGender bookingCabGender) throws AdminException, CurrentUserSessionException {
          booking.bookbygender( "12"); // Assuming this method throws CurrentUserSessionException if session is invalid
        return ResponseEntity.ok("Cab booked successfully");
    }
}