package com.cab.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RatingRequest {
    private String tripBookingId;
    private Integer driverId;
    private int rating;
    private String feedBack;
}
