package com.cab.Repositary;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cab.Model.Admin;


@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{

    Optional<Admin> findByEmail(String email);
    Optional<Admin> findByAdminId(Integer adminId);
    @Query(value = "SELECT (SELECT COUNT(*) FROM customer) AS noOfUserRegistered, " +
            "(SELECT COUNT(*) FROM trip_booking) AS noOfBookings, " +
            "(SELECT COUNT(*) FROM trip_booking WHERE MONTH(from_date_time) = MONTH(CURRENT_DATE)) AS noOfBookingsLastMonth, " +
            "(SELECT COUNT(*) FROM driver) AS noOfDrivers, " +
            "(SELECT COUNT(*) FROM cab) AS noOfCab, "
            + "(SELECT COUNT(*) FROM admin where user_role='vendor') AS noOfVendor " ,
            nativeQuery = true)
    List<Object[]> getCountsForAdminDashboard();
    @Query("select a from Admin a where a.userRole = 'Vendor'")
	List<Admin> getAllVendor();
    @Query(value = "SELECT " +
            "(SELECT COUNT(*) FROM customer) AS noOfUserRegistered, " +
            "(SELECT COUNT(1) FROM trip_booking t " +
            "INNER JOIN driver d ON t.driver_driver_id = d.driver_id " +
            "INNER JOIN cab c ON t.cab_cab_id = c.cab_id " +
            "WHERE c.owner_email like :vendorEmail OR d.owner_email like :vendorEmail) AS noOfBookings, " +
            "(SELECT COUNT(*) FROM trip_booking WHERE MONTH(from_date_time) = MONTH(CURRENT_DATE)) AS noOfBookingsLastMonth, " +
            "(SELECT COUNT(*) FROM driver WHERE owner_email = :vendorEmail) AS noOfDrivers, " +
            "(SELECT COUNT(*) FROM cab WHERE owner_email = :vendorEmail) AS noOfCab, " +
            "(SELECT COUNT(*) FROM admin WHERE user_role = 'vendor') AS noOfVendor " +
            "FROM DUAL",
            nativeQuery = true)
List<Object[]> getCountsForVendorDashboard(@Param("vendorEmail") String vendorEmail);

	@Query(value = "SELECT (SELECT COUNT(*) FROM customer) AS noOfUserRegistered, "+
            "(SELECT COUNT(*) FROM trip_booking where driver_driver_id=:driverId) AS noOfBookings, " +
            "(SELECT COUNT(*) FROM trip_booking WHERE MONTH(from_date_time) = MONTH(CURRENT_DATE)) AS noOfBookingsLastMonth, " +
            "(SELECT COUNT(*) FROM driver) AS noOfDrivers, " +
            "(SELECT COUNT(*) FROM cab) AS noOfCab, "
            + "(SELECT SUM(price) FROM trip_booking where driver_driver_id=:driverId and curr_status='Completed') AS total_earnings" ,             
            nativeQuery = true)
	List<Object[]> getCountsForDriverDashboard(@Param("driverId") int driverId);
}
