package com.cab.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DriverEarnings {
private double todayEarnings;
private double weeklyEarnings;
private double monthlyEarnings;
private double totalEarnings;
}
