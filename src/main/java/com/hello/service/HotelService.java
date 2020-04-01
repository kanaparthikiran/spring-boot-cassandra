/**
 * 
 */
package com.hello.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.entities.Hotel;
import com.hello.repository.HotelRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	public void testAllOperations() {
		Hotel sample = createHotel();
		this.hotelRepository.save(sample);

		Hotel findHotel = hotelRepository.findOne(sample.getId());
		log.info("Found the Hotel in the Database {}", sample);

		if (findHotel.getName().equalsIgnoreCase("Sample Hotel")) {
			log.info("The Hotel is Present so removing the Hotel ");
			this.hotelRepository.delete(findHotel.getId());
			log.info("Completed removing the Hotel ");
		} 
		else {
			log.info(" The Hotel with the name Sample Hotel does not exist");
		}
	}

	private Hotel createHotel() {
		Hotel hotel = new Hotel();
		hotel.setId(UUID.randomUUID());
		hotel.setName("Sample Hotel");
		hotel.setAddress("Sample Address");
		hotel.setZip("8764");
		return hotel;
	}

}