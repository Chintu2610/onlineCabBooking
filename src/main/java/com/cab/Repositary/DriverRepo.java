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
	
	Optional<Driver> findByDriverId(String driverId);

	List<Driver> findByCurrLocationAndCurrDriverStatus(String currLocation, String currDriverStatus);
	
	List<Driver> findByCurrDriverStatus(String currDriverStatus);
	
	@Query (value="SELECT * FROM driver",nativeQuery=true)
	List<Driver> getAllDrivers();
	
	@Query("SELECT c FROM CurrentUserSession c WHERE c.uuid = :uuid AND c.currRole = 'Admin'")
	Optional<CurrentUserSession> findmyusername(@Param("uuid") String uuid);
	
	@Query(value ="select * from driver where driver_id =?1 ",nativeQuery=true)
	Optional<Driver> findByusername(String driverid);
	@Query(value = "SELECT " +
		       "(SELECT COALESCE(SUM(price), 0) FROM trip_booking WHERE DATE(to_date_time) = CURRENT_DATE AND curr_status = 'Completed' AND driver_driver_id = :driverId) AS todayEarnings, " +
		       "(SELECT COALESCE(SUM(price), 0) FROM trip_booking WHERE to_date_time >= CURDATE() - INTERVAL 7 DAY AND to_date_time < CURDATE() + INTERVAL 1 DAY AND curr_status = 'Completed' AND driver_driver_id = :driverId) AS weeklyEarnings, " +
		       "(SELECT COALESCE(SUM(price), 0) FROM trip_booking WHERE MONTH(to_date_time) = MONTH(CURRENT_DATE) AND YEAR(to_date_time) = YEAR(CURRENT_DATE) AND curr_status = 'Completed' AND driver_driver_id = :driverId) AS monthlyEarnings, " +
		       "(SELECT COALESCE(SUM(price), 0) FROM trip_booking WHERE curr_status = 'Completed' AND driver_driver_id = :driverId) AS totalEarnings " +
		       "FROM DUAL", nativeQuery = true)
	List<Object[]> GetDriverEarnings(@Param("driverId") String driverId);



	
}
