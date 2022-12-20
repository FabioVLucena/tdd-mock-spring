package com.aeon.tdd;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.aeon.tdd.model.BookingModel;
import com.aeon.tdd.repository.BookingRepository;
import com.aeon.tdd.service.BookingService;

@ExtendWith(SpringExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class BookingServiceTest {

	@TestConfiguration
	static class BookingServiceTestConfiguration {
		
		@Bean
		public BookingService bookingService() {
			return new BookingService();
		}
	}
	
	@Autowired
	BookingService bookingService;
	
	@MockBean
	BookingRepository bookingRepository;
	
	@Test
	public void bookingTestServiceDaysCalculator() {
		int expectedDays = 10;
		
		String name = "Michelli";
		int days = bookingService.daysCalculatorWithDataBase(name);
		
		Assertions.assertEquals(expectedDays, days);
	}

	@BeforeAll
	public void setup() {
		LocalDate checkIn = LocalDate.parse("2020-11-10");
		LocalDate checkOut = LocalDate.parse("2020-11-20");
		BookingModel bookingModel = new BookingModel("1", "Michelli", checkIn, checkOut, "2");
		
		Mockito.when(bookingRepository.findByReserveName(bookingModel.getReserveName()))
			   .thenReturn(Optional.of(bookingModel));
	}
}
