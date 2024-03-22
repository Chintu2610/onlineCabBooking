package com.cab.Service;

import com.cab.Exception.AdminException;

import com.cab.Exception.CurrentUserSessionException;
import com.cab.Model.BookingCabGender;


public interface BookingCabGenderService {
	
	BookingCabGender bookbygender(String uuid) throws AdminException,CurrentUserSessionException;   
}
