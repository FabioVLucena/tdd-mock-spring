package com.aeon.tdd;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.aeon.tdd.model.BookingModel;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class BookingControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	public void bookingTestGelAll() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/bookings"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string("Hello world"));
	}
	
	@Test
	public void bookingTestSave() throws Exception {
		LocalDate checkIn = LocalDate.parse("2020-11-10");
		LocalDate checkOut = LocalDate.parse("2020-11-20");
		
		BookingModel bookingModel = new BookingModel("1", "Michelli", checkIn, checkOut, "2");
			
		mockMvc.perform(MockMvcRequestBuilders.post("/bookings")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsBytes(bookingModel)))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$.reserveName").value("Michelli"));
	}
}
