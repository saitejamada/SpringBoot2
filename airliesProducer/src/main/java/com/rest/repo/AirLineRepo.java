package com.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.model.Airlines;


public interface AirLineRepo extends JpaRepository<Airlines,String> {

	
}
