package com.rest.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.exception.AirlinePassengerException;
import com.rest.model.Airlines;
import com.rest.model.Passengers;
import com.rest.repo.AirLineRepo;
import com.rest.repo.PassengersRepo;


@Service
public class AirlinePassengerService {

	@Autowired
	PassengersRepo passengerRepo;
	@Autowired
	AirLineRepo airlineRepo;
	
	public Optional<Airlines> findOneAirline(String id) {
		Optional<Airlines> optional=airlineRepo.findById(id);
		if(!optional.isPresent()) {
			throw new AirlinePassengerException("no Airlines found with id"+id);
		}
		else {
			return optional;
		}
				
	}
	public List<Airlines>  findAllAirlines(){
		return airlineRepo.findAll();
	}
	public Airlines saveAirline(Airlines a) {
		return airlineRepo.save(a);
	}
	public void deleteAirline(String id) {
		try {
			airlineRepo.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new AirlinePassengerException("no Airlines found with id"+id);
		}
		
	}
	public Airlines updateAirline(Airlines a,String id) {
		try {
			Airlines a1=airlineRepo.findById(id).get();
			return airlineRepo.save(a);
		} catch (Exception e) {
			// TODO: handle exception
			throw new AirlinePassengerException("no Airlines found with id"+id);
		}
		
	}
	
	public Passengers findOnePasseneger(String id) {
		try {
			Passengers p= passengerRepo.findById(id).get();
			return p;
		} catch (Exception e) {
			// TODO: handle exception
			throw new AirlinePassengerException("no passenger found with id"+id);
		}
		
	}
	public List<Passengers> findAllPassenegrs(){
		return passengerRepo.findAll();
	}
	public Passengers savePassenger(Passengers p) {
		return passengerRepo.save(p);
	}
	public void deletePassenger(String id) {
		try {
			passengerRepo.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
			throw new AirlinePassengerException("no passenger found with id"+id);
		}
		
	}
	public Passengers updatePassenger(Passengers p,String id) {
		try {
			Passengers p1=passengerRepo.findById(id).get();
			return passengerRepo.save(p);
		} catch (Exception e) {
			// TODO: handle exception
			throw new AirlinePassengerException("no passenger found with id"+id);
		}
		
	}
	public void saveAllAirlines(List<Airlines> a) {
		airlineRepo.saveAll(a);
	}
	public void saveAllPassengers(List<Passengers> p) {
		passengerRepo.saveAll(p);
	}
}
