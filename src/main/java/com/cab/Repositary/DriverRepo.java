package com.cab.Repositary;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cab.Model.CurrentUserSession;
import com.cab.Model.Customer;
import com.cab.Model.Driver;

public interface DriverRepo extends JpaRepository<Driver, Integer>{

	Optional<Driver> findByLicenceNo(String licenceNo);
	
	Optional<Driver> findByEmail(String email);

	List<Driver> findByCurrLocationAndCurrDriverStatus(String currLocation, String currDriverStatus);
	
	List<Driver> findByCurrDriverStatus(String currDriverStatus);
	
	@Query (value="SELECT * FROM driver",nativeQuery=true)
	List<Driver> getAllDrivers();
	
	@Query("SELECT c FROM CurrentUserSession c WHERE c.uuid = :uuid AND c.currRole = 'Admin'")
	Optional<CurrentUserSession> findmyusername(@Param("uuid") String uuid);
	
	@Query(value ="select * from driver where driver_id =?1 ",nativeQuery=true)
	Optional<Driver> findByusername(String username);
}
