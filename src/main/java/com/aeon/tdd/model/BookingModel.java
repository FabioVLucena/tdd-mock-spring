package com.aeon.tdd.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class BookingModel {

	@Id
	private String id;
	private String reserveName;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private String numberGuests;
	
}
