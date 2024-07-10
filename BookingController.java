package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.BookingNotFoundException;
import com.model.Booking;
import com.service.BookingService;

@RequestMapping("/b")
@RestController
public class BookingController {

	@Autowired
	BookingService bookingService;

/*
-------------------------------------------------------------------------------------------------------------------------	
-------------------------------------------------------------------------------------------------------------------------	
*/
	
	@PostMapping("/add")
	public ResponseEntity<Booking> AddBooking(@RequestBody Booking booking)
	{
		Booking b = bookingService.saveBooking(booking);
		return ResponseEntity.status(HttpStatus.CREATED).header("booking","booking done").body(b);
	}
	

/*
-------------------------------------------------------------------------------------------------------------------------	
-------------------------------------------------------------------------------------------------------------------------	
*/
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Map<String, Object>> getOneBooking(@PathVariable long id) throws BookingNotFoundException
	{
		Map<String, Object> response = bookingService.getBookingById(id);
		
		return ResponseEntity.ok(response);
	}
	
/*
-------------------------------------------------------------------------------------------------------------------------	
-------------------------------------------------------------------------------------------------------------------------	
*/
	
	@GetMapping("/getAll")
	public List<Booking> getAllBooking(){
		return bookingService.getAllBooking();
		
	}
	
/*
-------------------------------------------------------------------------------------------------------------------------	
-------------------------------------------------------------------------------------------------------------------------	
*/	
	
	@PutMapping("/update")
	public ResponseEntity<Booking> updateBooking(@RequestBody Booking booking){
		
		Booking b = bookingService.updateBooking(booking);
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("booking", "booking updated").body(b);
	}
	
/*
-------------------------------------------------------------------------------------------------------------------------	
-------------------------------------------------------------------------------------------------------------------------	
*/
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Map<String, Object>> cancelBooking(@PathVariable ("id") long id) throws BookingNotFoundException{
		Map<String, Object> response = bookingService.deleteBooking(id);
		
		return ResponseEntity.ok(response);
	}
}
