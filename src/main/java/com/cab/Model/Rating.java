package com.cab.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Rating {
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Id
	private Integer id;
	@Column(name="rating")
	private int rating;
	@Column(name="feedBack")
	private String feedBack;
	
	@ManyToOne
	@JoinColumn(name = "driverId", nullable = false)
	private Driver driver;
	
	@Column(name="tripBookingId",nullable = false)
	private String tripBookingId;
}
