package com.travel.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.model.Flight;


public interface FlightRepo extends JpaRepository<Flight, Integer> {

	List<Flight> findByFlightfromAndFlightto(String from,String to);
}
