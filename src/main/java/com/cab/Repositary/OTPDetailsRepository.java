package com.cab.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cab.Model.OTPDetails;


@Repository
public interface OTPDetailsRepository extends JpaRepository<OTPDetails, Integer>{
	@Query(value="select otp from otpdetails where email=?1 and otp=?2",nativeQuery=true)
	public String getOtp(String email,String otp);
}
