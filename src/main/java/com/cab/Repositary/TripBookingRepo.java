package com.cab.Repositary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cab.Model.TripBooking;

import java.util.List;
import java.util.Optional;

@Repository
public interface TripBookingRepo extends JpaRepository<TripBooking, Integer> {

    Optional<TripBooking> findByTripBookingId(String tripBookingId);

    @Query(value = "SELECT * FROM trip_booking t WHERE t.driver_driver_id = :driverId AND DATE(t.to_date_time) = CURDATE() AND curr_status = 'Completed'", nativeQuery = true)
    List<TripBooking> findDailyTransactions(@Param("driverId") Integer driverId);


    //@Query(value = "SELECT * FROM trip_booking t WHERE t.driver_driver_id = :driverId AND YEARWEEK(t.to_date_time, 1) = YEARWEEK(CURDATE(), 1) AND curr_status = 'Completed'", nativeQuery = true)
    @Query(value = "SELECT *\r\n"
    		+ "FROM trip_booking t\r\n"
    		+ "WHERE t.driver_driver_id = :driverId\r\n"
    		+ "AND t.to_date_time >= CURDATE() - INTERVAL 7 DAY\r\n"
    		+ "AND t.to_date_time < CURDATE() + INTERVAL 1 DAY\r\n"
    		+ "AND curr_status = 'Completed';", nativeQuery = true)
    
    List<TripBooking> findWeeklyTransactions(@Param("driverId") Integer driverId);


    @Query(value = "SELECT * FROM trip_booking t WHERE t.driver_driver_id = :driverId AND MONTH(t.to_date_time) = MONTH(CURDATE()) AND YEAR(t.to_date_time) = YEAR(CURDATE()) AND curr_status = 'Completed'", nativeQuery = true)
    List<TripBooking> findMonthlyTransactions(@Param("driverId") Integer driverId);


    @Query(value = "SELECT * FROM trip_booking t WHERE t.driver_driver_id = :driverId AND curr_status = 'Completed'", nativeQuery = true)
    List<TripBooking> findTotalTransactions(@Param("driverId") Integer driverId);

}
