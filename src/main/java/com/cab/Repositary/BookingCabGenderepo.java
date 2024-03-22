package com.cab.Repositary;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cab.Model.BookingCabGender;
@Repository
public interface BookingCabGenderepo extends JpaRepository<BookingCabGender, Integer>{

	 String HttpStatus = null;
	 
}
