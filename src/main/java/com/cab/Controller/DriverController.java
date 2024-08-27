package com.cab.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cab.Exception.CurrentUserSessionException;
import com.cab.Exception.CustomerException;
import com.cab.Exception.DriverException;
import com.cab.Model.Customer;
import com.cab.Model.Driver;
import com.cab.Model.DriverEarnings;
import com.cab.Model.TripBookingDTO;
import com.cab.Service.DriverService;

@CrossOrigin
@RestController
@RequestMapping("/driver")
public class DriverController {

	@Autowired
	private DriverService driverService;
	
	@PostMapping("/register")
	public ResponseEntity<Driver> register(@RequestBody Driver driver) throws DriverException{
		
		return new ResponseEntity<Driver>(driverService.insertDriver(driver),HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Driver> update(@RequestBody Driver driver, @RequestParam("uuid") String uuid,@RequestParam(value = "driverId", required = false, defaultValue = "0") String driverId) throws DriverException, CurrentUserSessionException{
		return new ResponseEntity<Driver>(driverService.updateDriver(driver, uuid,driverId),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Driver> delete(@RequestParam("driverId") Integer driverId,@RequestParam("uuid") String uuid) throws DriverException, CurrentUserSessionException{
		return new ResponseEntity<Driver>(driverService.deleteDriver(driverId, uuid),HttpStatus.OK);
	}
	
	@GetMapping("/viewBestDriver")
	public ResponseEntity<List<Driver>> viewBestDriver(@RequestParam("uuid") String uuid) throws DriverException, CurrentUserSessionException{
		return new ResponseEntity<List<Driver>>(driverService.viewBestDriver(uuid),HttpStatus.OK);
	}
	
	@GetMapping("viewDriver")
	public ResponseEntity<Driver> viewDriver(@RequestParam("driverId") Integer driverId,@RequestParam("uuid")String uuid) throws DriverException, CurrentUserSessionException{
		return new ResponseEntity<Driver>(driverService.viewDriver(driverId, uuid),HttpStatus.OK);
	}
	
	@GetMapping("/AllDriver")
    public ResponseEntity<List<Driver>> allDrivers(@RequestParam("uuid") String uuid) throws DriverException, CurrentUserSessionException {
        
		List<Driver> allDrivers = driverService.viewAllDriver( uuid);
        return new ResponseEntity<>(allDrivers, HttpStatus.OK);
    }
	
	@GetMapping("/GetDriverDetails")
	public ResponseEntity<Driver> GetDriverDetails(@RequestParam("driverid") String driverid,@RequestParam("uuid") String uuid) throws CustomerException, CurrentUserSessionException{
		return new ResponseEntity<Driver>(driverService.GetDriverData(driverid, uuid),HttpStatus.OK);
	}
	@GetMapping("/GetDriverEarnings")
	public ResponseEntity<DriverEarnings> GetDriverEarnings(@RequestParam("driverid") String driverid,@RequestParam("uuid") String uuid) throws CustomerException, CurrentUserSessionException{
		return new ResponseEntity<DriverEarnings>(driverService.GetDriverEarnings(driverid, uuid),HttpStatus.OK);
	}
	
	@GetMapping("/getTransactionDetails")
    public ResponseEntity<Map<String, List<TripBookingDTO>>> getTransactionDetails(
            @RequestParam String driverid,
            @RequestParam String uuid,
            @RequestParam String period) {

        Map<String, List<TripBookingDTO>> response = new HashMap<>();
        try {
            switch (period.toLowerCase()) {
                case "daily":
                    response.put("daily", driverService.getDailyTransactions(driverid, uuid));
                    break;
                case "weekly":
                    response.put("weekly", driverService.getWeeklyTransactions(driverid, uuid));
                    break;
                case "monthly":
                    response.put("monthly", driverService.getMonthlyTransactions(driverid, uuid));
                    break;
                case "total":
                    response.put("total", driverService.getTotalTransactions(driverid, uuid));
                    break;
                default:
                    return ResponseEntity.badRequest().body(null);
            }
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

}	
}

