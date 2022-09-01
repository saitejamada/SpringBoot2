package com.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.model.Passengers;



public interface PassengersRepo extends JpaRepository<Passengers, String> {

	
}
