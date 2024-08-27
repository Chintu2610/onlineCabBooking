package com.cab.Repositary;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
    @Query(value = "SELECT (SELECT COUNT(*) FROM customer) AS noOfUserRegistered, " +
            "(SELECT COUNT(*) FROM trip_booking) AS noOfBookings, " +
            "(SELECT COUNT(*) FROM trip_booking WHERE MONTH(from_date_time) = MONTH(CURRENT_DATE)) AS noOfBookingsLastMonth, " +
            "(SELECT COUNT(*) FROM driver) AS noOfDrivers, " +
            "(SELECT COUNT(*) FROM cab where owner_email=?1) AS noOfCab, "
            + "(SELECT COUNT(*) FROM admin where user_role='vendor') AS noOfVendor " ,
            nativeQuery = true)
	List<Object[]> getCountsForVendorDashboard(String vendorEmail);
	@Query(value = "SELECT (SELECT COUNT(*) FROM customer) AS noOfUserRegistered, " +
            "(SELECT COUNT(*) FROM trip_booking where driver_driver_id=?1) AS noOfBookings, " +
            "(SELECT COUNT(*) FROM trip_booking WHERE MONTH(from_date_time) = MONTH(CURRENT_DATE)) AS noOfBookingsLastMonth, " +
            "(SELECT COUNT(*) FROM driver) AS noOfDrivers, " +
            "(SELECT COUNT(*) FROM cab) AS noOfCab, "
            + "(SELECT COUNT(*) FROM admin where user_role='vendor') AS noOfVendor ",             
            nativeQuery = true)
	List<Object[]> getCountsForDriverDashboard(int driverId);
}
