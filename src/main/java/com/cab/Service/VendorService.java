package com.cab.Service;


import java.util.List;

import com.cab.Exception.CurrentUserSessionException;
import com.cab.Exception.DriverException;
import com.cab.Exception.VendorException;
import com.cab.Model.Admin;




public interface VendorService {

    List<Admin> viewAllVendor(String uuid);

	Admin viewVendor(Integer vendorId, String uuid) throws VendorException, CurrentUserSessionException;

	Admin updateVendor(Admin admin, String uuid) throws VendorException, CurrentUserSessionException;

	Admin deleteVendor(Integer vendorId, String uuid) throws VendorException, CurrentUserSessionException;

	String approveVendor(String vendorId, String uuid) throws VendorException, CurrentUserSessionException;
	
}
