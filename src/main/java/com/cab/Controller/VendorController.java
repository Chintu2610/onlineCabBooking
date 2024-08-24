package com.cab.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cab.Exception.CurrentUserSessionException;
import com.cab.Exception.CustomerException;
import com.cab.Exception.DriverException;
import com.cab.Exception.VendorException;
import com.cab.Model.Admin;
import com.cab.Model.Customer;
import com.cab.Model.Driver;
import com.cab.Service.AdminService;
import com.cab.Service.DriverService;
import com.cab.Service.VendorService;

@CrossOrigin
@RestController
@RequestMapping("/vendor")
public class VendorController {

	@Autowired
	private VendorService vendorService;
	
	@GetMapping("/AllVendor")
    public ResponseEntity<List<Admin>> allVendors(@RequestParam String uuid) throws DriverException, CurrentUserSessionException {
        List<Admin> allVendors = vendorService.viewAllVendor(uuid);
        return new ResponseEntity<>(allVendors, HttpStatus.OK);
    }
	@GetMapping("viewVendor/{vendorId}")
	public ResponseEntity<Admin> viewDriver(@PathVariable("vendorId") Integer vendorId,@RequestParam("uuid")String uuid) throws VendorException, CurrentUserSessionException{
		return new ResponseEntity<Admin>(vendorService.viewVendor(vendorId, uuid),HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<Admin> update(@RequestBody Admin admin, @RequestParam("uuid") String uuid) throws VendorException, CurrentUserSessionException{
		return new ResponseEntity<Admin>(vendorService.updateVendor(admin, uuid),HttpStatus.OK);
	}
	@DeleteMapping("/delete")
	public ResponseEntity<Admin> delete(@RequestParam("vendorId") Integer vendorId,@RequestParam("uuid") String uuid) throws VendorException, CurrentUserSessionException{
		return new ResponseEntity<Admin>(vendorService.deleteVendor(vendorId, uuid),HttpStatus.OK);
	}
}	

