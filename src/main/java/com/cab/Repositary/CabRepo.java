package com.cab.Repositary;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cab.Model.Cab;

public interface CabRepo extends JpaRepository<Cab, Integer>{

	Optional<Cab> findByCarNumber(String carNumber);
	@Query("select c from Cab c where CurrLocation like %?1%")
	List<Cab> findByCurrLocation(String currLocation);
}
