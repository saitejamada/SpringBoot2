package com.travel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.model.Bus;
import com.travel.model.Flight;
import com.travel.model.Train;
import com.travel.model.Travel;
import com.travel.model.User;
import com.travel.repo.BusRepo;
import com.travel.repo.FlightRepo;
import com.travel.repo.Trainrepo;
import com.travel.repo.Travelrepo;
import com.travel.repo.UserRepo;

@Service
public class TravelSerevice {

	@Autowired
	UserRepo ur;
	
	@Autowired
	Travelrepo tr;
	
	@Autowired
	BusRepo br;
	
	@Autowired
	FlightRepo fr;
	
	@Autowired
	Trainrepo trainrepo;
	
	
	public void addTrain(Train t)
	{
		trainrepo.save(t);
	}
	
	public List<Train> getTrain(String from,String to)
	{
		return trainrepo.findByTrainfromAndTrainto(from, to);
	}
	public List<Train> getTrains()
	{
		return trainrepo.findAll();
	}
	
	public void addUser(User u)
	{
		ur.save(u);
	}
	public void addtravel(Travel t)
	{
		tr.save(t);
	}
	
	public void addBus(Bus b)
	{
		br.save(b);
	}
	public List<Bus> viewAllBus()
	{
		return br.findAll();
	}
	public List<Bus> viewBus(String from)
	{
		List<Bus> list= br.findBybusfrom(from);
		System.out.println(list);
		return list;
		
	}
	public List<Bus> viewBuses()
	{
		List<Bus> list= br.findAll();
		return list;
		
	}
	public User viewUser(int id)
	{
		return ur.findById(id).get();
	}
	public Travel viewTravel(int id) {
		return tr.findById(id).get();
	}
	public void deleteUser(int id) {
		ur.deleteById(id);
	}
	public void deleteTravel(int id) {
		tr.deleteById(id);
	}
	public String validateUser(User c1)
	{
		User c=ur.findById(c1.getUserid()).get();
		System.out.println("in service"+c);
		if(c==null)
			return null;
		else
		return c.getType();
	}
	public void addFlight(Flight f)
	{
		fr.save(f);
	}
	
	public List<Flight> getAllFlights(String from,String to){
		 List<Flight> list=fr.findByFlightfromAndFlightto(from, to);
		 return list;
	}
	public List<Flight> getAllFlights(){
		 List<Flight> list=fr.findAll();
		 return list;
	}
}
