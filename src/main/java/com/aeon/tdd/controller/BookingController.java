package com.aeon.tdd.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aeon.tdd.model.BookingModel;

@RestController
@RequestMapping("/bookings")
public class BookingController {

	@GetMapping
	public ResponseEntity<String> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body("Hello world");
	}
	
	@PostMapping
	public ResponseEntity<BookingModel> save(@RequestBody BookingModel bookingModel) {
		return ResponseEntity.status(HttpStatus.OK).body(bookingModel);
	}
}
