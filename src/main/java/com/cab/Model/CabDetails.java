package com.cab.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CabDetails {
	private int  id;
    private String type;
    private int maxPassengers;
    private Price price;
    private long eta;
    private String description;

}
