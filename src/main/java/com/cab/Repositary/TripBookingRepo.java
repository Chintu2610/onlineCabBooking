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

    @Query(value = "SELECT * FROM trip_booking t WHERE t.driver_driver_id = :driverId AND DATE(t.to_date_time) = CURDATE()", nativeQuery = true)
    List<TripBooking> findDailyTransactions(@Param("driverId") Integer driverId);

    @Query(value = "SELECT * FROM trip_booking t WHERE t.driver_driver_id = :driverId AND WEEK(t.to_date_time) = WEEK(CURDATE())", nativeQuery = true)
    List<TripBooking> findWeeklyTransactions(@Param("driverId") Integer driverId);

    @Query(value = "SELECT * FROM trip_booking t WHERE t.driver_driver_id = :driverId AND MONTH(t.to_date_time) = MONTH(CURDATE())", nativeQuery = true)
    List<TripBooking> findMonthlyTransactions(@Param("driverId") Integer driverId);

    @Query(value = "SELECT * FROM trip_booking t WHERE t.driver_driver_id = :driverId", nativeQuery = true)
    List<TripBooking> findTotalTransactions(@Param("driverId") Integer driverId);
}
