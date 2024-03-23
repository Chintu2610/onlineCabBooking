package com.cab.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cab.Model.OTPDetails;
import com.cab.Repositary.OTPDetailsRepository;




@Service
public class OTPService {
	
	@Autowired
	OTPDetailsRepository otprepo;
	/*
	 * @Autowired OTPDetailsRepository otpDetailsRepository;
	 * 
	 * @Autowired DemoRepository repository;
	 */
	
	public void storeOTP(String email, int otp1) {
		OTPDetails otpDetails = new OTPDetails();
		long otp=otp1;
		otpDetails.setEmail(email);
		otpDetails.setOtp(otp);
		otprepo.save(otpDetails);
		
		/* demosrv.saveUser(); */
		/*
		 * otpDetails.setEmail(email); otpDetails.setOtp(otp); // Current timestamp is
		 * automatically set by Spring Data JPA otpDetails.setTime(null);
		 */
//		Demo d=new Demo();
//		d.setId(3);
//		d.setName("aravind");
//		repository.save(d);
		/*
		 * otpDetails.setId(1); otpDetails.setName("chintu");
		 * System.out.println(otpDetails); otpDetailsRepository.save(otpDetails);
		 */
	}
	
	public long StoredOpt(String email)
	{
		OTPDetails details= otprepo.getOtp(email);
		return details.getOtp();
	}
}
