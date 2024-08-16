package com.cab.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.multipart.MultipartFile;

import com.cab.Exception.CabException;
import com.cab.Exception.CurrentUserSessionException;
import com.cab.Model.Cab;
import com.cab.Service.CabService;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
@CrossOrigin
@RestController
@RequestMapping("/cab")
public class CabController {
	
	@Autowired
	private CabService cabService;
	
	
	@PostMapping("/register")
	public ResponseEntity<Cab> register(@RequestParam("file") MultipartFile file,
            @RequestParam("carType") String carType,
            @RequestParam("carName") String carName,
            @RequestParam("modelName") String modelName,
            @RequestParam("carNumber") String carNumber,
            @RequestParam("perKmRate") float perKmRate,
            @RequestParam("manufacturingYear") float manufacturingYear,
            @RequestParam("currLocation") String currLocation,
            @RequestParam("area") String area,
            @RequestParam("cabCurrStatus") String cabCurrStatus) throws CabException{
		 try {
	            // Save the file to the directory
	            if (!file.isEmpty()) {
	                byte[] bytes = file.getBytes();

	                // Resolve the full path to the image file
//	                String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/assets/cab-images";
	                //String uploadDirectory = "C:\\Users\\byama\\Desktop\\Documents\\WebLabs Projects\\CabBooking\\Frontend-Online-Cab-Booking\\Frontend-Online-Cab-Booking-Application_18_06\\Frontend-Online-Cab-Booking-Application\\assets\\cab-images";
	                String uploadDirectory = "C:\\Users\\byama\\Desktop\\Documents\\WebLabs Projects\\CabBookingReact08_03\\CabBooking\\public\\images\\cabImages";

		            String fileName = file.getOriginalFilename();
		            File destFile = new File(uploadDirectory + File.separator + fileName);
		            file.transferTo(destFile);

		            // Set the imageUrl to the file name
		            String imageUrl = fileName;

	                // Create a new Cab instance
	                Cab cab = new Cab();
	                cab.setCarType(carType);
	                cab.setCarName(carName);
	                cab.setCarNumber(carNumber);
	                cab.setModelName(modelName);
	                cab.setPerKmRate(perKmRate);
	                cab.setCurrLocation(currLocation);
	                cab.setCabCurrStatus(cabCurrStatus);
	                cab.setCabImage(imageUrl); // Relative path for the database
	                cab.setArea(area);
	                cab.setManufacturingYear(manufacturingYear);
	                // Save the Cab object using the service
	                Cab savedCab = cabService.insertCab(cab);
	                
	                // Return response with CREATED status and saved Cab entity
	                return new ResponseEntity<>(savedCab, HttpStatus.CREATED);
	            } else {
	                return ResponseEntity.badRequest().build(); // File is empty
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	        }
	}
	
//	@PutMapping("/update")
//	public ResponseEntity<Cab> update(@RequestBody Cab cab,@RequestParam("uuid") String uuid) throws CabException, CurrentUserSessionException{
//		return new ResponseEntity<Cab>(cabService.updateCab(cab, uuid),HttpStatus.OK);
//	}
	
	 @PutMapping("/update")
	    public ResponseEntity<Cab> update(@RequestParam("cabId") int cabId,
	                                      @RequestParam("carType") String carType,
	                                      @RequestParam("carName") String carName,
	                                      @RequestParam("carNumber") String carNumber,
	                                      @RequestParam("perKmRate") float perKmRate,
	                                      @RequestParam("currLocation") String currLocation,
	                                      @RequestParam("cabCurrStatus") String cabCurrStatus,
	                                      @RequestParam(value = "carImage", required = false) MultipartFile file,
	                                      @RequestParam("uuid") String uuid) throws CabException, CurrentUserSessionException {
		 try {
	            // Save the file to the directory
	            if (!file.isEmpty()) {
		 String uploadDirectory = "C:\\Users\\byama\\Desktop\\Documents\\WebLabs Projects\\CabBooking\\Frontend-Online-Cab-Booking\\Frontend-Online-Cab-Booking-Application_18_06\\Frontend-Online-Cab-Booking-Application\\assets\\cab-images";

         String fileName = file.getOriginalFilename();
         File destFile = new File(uploadDirectory + File.separator + fileName);
         file.transferTo(destFile);
         String imageUrl = fileName;
         
	        Cab cab = new Cab();
	        cab.setCabId(cabId);
	        cab.setCarType(carType);
	        cab.setCarName(carName);
	        cab.setCarNumber(carNumber);
	        cab.setPerKmRate(perKmRate);
	        cab.setCurrLocation(currLocation);
	        cab.setCabCurrStatus(cabCurrStatus);
	        cab.setCabImage(imageUrl);
	        Cab updatedCab = cabService.updateCab(cab, uuid);
	            
	        return new ResponseEntity<>(updatedCab, HttpStatus.OK);
	            }
	        else {
                return ResponseEntity.badRequest().build(); // File is empty
            }
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	 }
	


	
	@DeleteMapping("/delete")
	public ResponseEntity<Cab> deleteCab(@RequestParam("cabId") Integer cabId,@RequestParam("uuid") String uuid) throws CabException, CurrentUserSessionException{
		return new ResponseEntity<Cab>(cabService.deleteCab(cabId, uuid),HttpStatus.OK);
	}
	
	@GetMapping("/viewCabsOfType/{carType}")
	public ResponseEntity<List<Cab>> viewCabsOfType(@PathVariable("carType") String carType,@RequestParam("uuid") String uuid) throws CabException, CurrentUserSessionException{
		return new ResponseEntity<List<Cab>>(cabService.viewCabsOfType(carType, uuid),HttpStatus.OK);
	}
	
	@GetMapping("/getAllAvailableCab")
	public ResponseEntity<List<Cab>> getAllAvailableCab() throws CabException, CurrentUserSessionException{
		return new ResponseEntity<List<Cab>>(cabService.getAllAvailableCab( ),HttpStatus.OK);
	}
	@GetMapping("/getSingleCabDetails/{cabId}")
	public ResponseEntity<Cab> getSingleCabDetails(@PathVariable("cabId") String cabId) throws CabException, CurrentUserSessionException{
		return new ResponseEntity<Cab>(cabService.getSingleCabDetails(cabId),HttpStatus.OK);
	}
	
	@GetMapping("/countCabsOfType/{carType}")
	public ResponseEntity<Integer> countCabsOfType(@PathVariable("carType") String carType,@RequestParam("uuid") String uuid) throws CabException, CurrentUserSessionException{
		return new ResponseEntity<Integer>(cabService.countCabsOfType(carType, uuid),HttpStatus.OK);
	}
	@GetMapping("/getAvailableCabByCity")
	public ResponseEntity<List<Cab>> getAvailableCabByCity(@RequestParam("city") String city) throws CabException, CurrentUserSessionException{
		return new ResponseEntity<List<Cab>>(cabService.getAvailableCabByCity( city),HttpStatus.OK);
	}
}


	
