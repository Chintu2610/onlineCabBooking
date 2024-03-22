package com.cab.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cab.Exception.AdminException;
import com.cab.Exception.CurrentUserSessionException;
import com.cab.Model.BookingCabGender;
import com.cab.Repositary.BookingCabGenderepo;

@Service
public class BookingCabGenderServiceImpl implements BookingCabGenderService{
	@Autowired
	BookingCabGenderepo repo;
	@Override
	public BookingCabGender bookbygender( String uuid)
			throws AdminException, CurrentUserSessionException {	
		// TODO Auto-generated method stub
		return null;
	}
}
