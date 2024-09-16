package com.cab.Model;

import java.time.LocalDateTime;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Report {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="driver_id",referencedColumnName ="driverId")
	private Driver driver;
	
	@ManyToOne
	@JoinColumn(name="trip_id",referencedColumnName ="tripBookingId")
	private TripBooking trip;
	@OneToOne
	@JoinColumn(name="customer_id",referencedColumnName = "customerId")
	private Customer customer;
	private String subject;
	private String description;
	private String status;
	private LocalDateTime  created_at;
	private LocalDateTime updated_at;
	

	
	
}
