package com.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.model.Travel;
import com.travel.model.User;
import com.travel.repo.Travelrepo;
import com.travel.repo.UserRepo;

@Service
public class TravelSerevice {

	@Autowired
	UserRepo ur;
	
	@Autowired
	Travelrepo tr;
	
	public void addUser(User u)
	{
		ur.save(u);
	}
	public void addtravel(Travel t)
	{
		tr.save(t);
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
}
