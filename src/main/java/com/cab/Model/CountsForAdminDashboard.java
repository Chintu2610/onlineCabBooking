package com.cab.Model;

public class CountsForAdminDashboard {
	private int noOfUserRegistered;
	private int noOfBookings;
	private int noOfBookingsLastMonth;
	private int noOfDrivers;
	private int noOfUserRegisteredLastMonth;
	public CountsForAdminDashboard() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CountsForAdminDashboard(int noOfUserRegistered, int noOfBookings, int noOfBookingsLastMonth, int noOfDrivers,
			int noOfUserRegisteredLastMonth) {
		super();
		this.noOfUserRegistered = noOfUserRegistered;
		this.noOfBookings = noOfBookings;
		this.noOfBookingsLastMonth = noOfBookingsLastMonth;
		this.noOfDrivers = noOfDrivers;
		this.noOfUserRegisteredLastMonth = noOfUserRegisteredLastMonth;
	}
	public int getNoOfUserRegistered() {
		return noOfUserRegistered;
	}
	public void setNoOfUserRegistered(int noOfUserRegistered) {
		this.noOfUserRegistered = noOfUserRegistered;
	}
	public int getNoOfBookings() {
		return noOfBookings;
	}
	public void setNoOfBookings(int noOfBookings) {
		this.noOfBookings = noOfBookings;
	}
	public int getNoOfBookingsLastMonth() {
		return noOfBookingsLastMonth;
	}
	public void setNoOfBookingsLastMonth(int noOfBookingsLastMonth) {
		this.noOfBookingsLastMonth = noOfBookingsLastMonth;
	}
	public int getNoOfDrivers() {
		return noOfDrivers;
	}
	public void setNoOfDrivers(int noOfDrivers) {
		this.noOfDrivers = noOfDrivers;
	}
	public int getNoOfUserRegisteredLastMonth() {
		return noOfUserRegisteredLastMonth;
	}
	public void setNoOfUserRegisteredLastMonth(int noOfUserRegisteredLastMonth) {
		this.noOfUserRegisteredLastMonth = noOfUserRegisteredLastMonth;
	}
}
