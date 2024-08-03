package com.cab.Repositary;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cab.Model.Admin;
import com.cab.Model.CountsForAdminDashboard;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{

    Optional<Admin> findByEmail(String email);
    Optional<Admin> findByAdminId(Integer adminId);
    @Query(value = "SELECT (SELECT COUNT(*) FROM customer) AS noOfUserRegistered, " +
            "(SELECT COUNT(*) FROM trip_booking) AS noOfBookings, " +
            "(SELECT COUNT(*) FROM trip_booking WHERE MONTH(from_date_time) = MONTH(CURRENT_DATE)) AS noOfBookingsLastMonth, " +
            "(SELECT COUNT(*) FROM driver) AS noOfDrivers " ,
            nativeQuery = true)
    List<Object[]> getCountsForAdminDashboard();

	
}
