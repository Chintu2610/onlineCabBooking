package com.cab.Model;



import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReportRequest {
	private Integer reportId;
    private Integer tripBookingId;
    private Integer driverId;
    private String driverUserName;
    private String complaint_by;
    private String subject;
    private String description;
    private String status;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
