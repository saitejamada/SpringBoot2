package com.rest.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Airlines;
import com.rest.model.Passengers;
import com.rest.service.AirlinePassengerService;

@RestController
public class AirlineRestApiController {

	@Autowired
	AirlinePassengerService service;
	
	@PostConstruct
	public void postConstruct() {
		Airlines airline[]=new Airlines[3];
		airline[0]=new Airlines("1234","air india","india","https://www.google.com/airindialog.png","fly high","mumbai","www.airindia.com","1969");;
		airline[1]=new Airlines("12349","jetairwys","india","https://www.google.com/jetairwayslog.png","above skies","mumbai","www.jetindia.com","1995");
		airline[2]=new Airlines("1235","air asia","india","https://www.google.com/airasialog.png","flying made easy","banglore","www.airasia.com","1989");
		List<Airlines> list=Arrays.asList(airline);
		service.saveAllAirlines(list);
		Passengers p=new Passengers("122","saiteja",12,airline[0],"hbjh");
		service.savePassenger(p);
		}
	
	
	
	@GetMapping("/airlines")
	public List<Airlines> getAllAirlines(){
		return service.findAllAirlines();
	}
	
	@GetMapping("/airlines/{id}")
	public Optional<Airlines> getOneAirline(@PathVariable("id") String id) {
		return service.findOneAirline(id);
	}
	@PostMapping("/airlines")
	public Airlines addOneAirline(@RequestBody Airlines a) {
		return service.saveAirline(a);
	}
	@DeleteMapping("/airlines/{id}")
	public void deleteAirlines(@PathVariable("id") String id) {
		 service.deleteAirline(id);
	}
	@PutMapping("/airlines/{id}")
	public Airlines updateAirlines(@RequestBody Airlines a,@PathVariable("id") String id) {
		return service.updateAirline(a, id);
	}
	@GetMapping("/passengers")
	public List<Passengers> getAllPassengers(){
		return service.findAllPassenegrs();
	}
	@GetMapping("/passengers/{id}")
	public Passengers getOnePassenegers(@PathVariable("id") String id) {
		return service.findOnePasseneger(id);
	}
	@PostMapping("/passengers")
	public Passengers addPassengers(@RequestBody Passengers p) {
		return service.savePassenger(p);
	}
	@PutMapping("/passengers/{id}")
	public Passengers updateOnePassenegers(@RequestBody Passengers p,@PathVariable("id") String id) {
		return service.updatePassenger(p, id);
	}
	@DeleteMapping("/passengers/{id}")
	public void deletePassengr(@PathVariable("id") String id) {
		service.deletePassenger(id);
	}
}
