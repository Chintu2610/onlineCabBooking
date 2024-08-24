package com.cab.Repositary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cab.Model.TripBooking;

@Repository
public interface TripBookingRepo extends JpaRepository<TripBooking, Integer>{

	Optional<TripBooking> findByTripBookingId(String tripBookingId);

}
