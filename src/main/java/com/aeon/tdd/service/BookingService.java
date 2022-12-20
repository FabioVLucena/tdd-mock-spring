package com.aeon.tdd.service;

import java.time.Period;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aeon.tdd.model.BookingModel;
import com.aeon.tdd.repository.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	BookingRepository bookingRepository;
	
	public int daysCalculatorWithDataBase(String name) {
		Optional<BookingModel> bookingModelOptional = bookingRepository.findByReserveName(name);
		BookingModel bookingModel = bookingModelOptional.get();
		
		if (bookingModel.equals(null))
			return 0;
		
		LocalDate checkIn = bookingModel.getCheckIn();
		LocalDate checkOut = bookingModel.getCheckOut();
		int days = Period.between(checkIn, checkOut).getDays();
		
		return days;
	}
	
	
	
}
