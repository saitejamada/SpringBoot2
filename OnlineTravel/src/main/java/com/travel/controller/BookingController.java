package com.travel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.travel.model.Bus;
import com.travel.model.Flight;
import com.travel.model.Train;
import com.travel.model.Travel;
import com.travel.model.User;
import com.travel.service.TravelSerevice;

@RestController
public class BookingController {

	@Autowired
	TravelSerevice ts;
	
	@GetMapping("/home")
	public ModelAndView goHome(Model m)
	{
		Travel u=new Travel();
		m.addAttribute("user", u);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("HomePage");
		return mv;
	}
	@PostMapping("/journey")
	public ModelAndView addJourney(@ModelAttribute("user") Travel t,Model m)
	{
		ts.addtravel(t);
		ModelAndView mv=new ModelAndView();
		List<Bus> list=ts.viewBus(t.getJourneyfrom());
		m.addAttribute("user", list);
		mv.setViewName("Main");
		return mv;
	}
	@GetMapping("/login")
	public  ModelAndView login(@ModelAttribute("user") User u,Model m) {
		
		String type=ts.validateUser(u);
		ModelAndView mv=new ModelAndView();
		if(type.equals("user"))
		{
			Travel us=new Travel();
			m.addAttribute("user", us);
			mv.setViewName("HomePage");
			return mv;
		}
		else {
			mv.setViewName("Admin");
			return mv;	
		}
	}
	@GetMapping("/li")
	public ModelAndView login(Model m) {
		User u=new User();
		m.addAttribute("user", u);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Login");
		return mv;
	}
	@GetMapping("/si")
	public ModelAndView Sign(Model m) {
		User u=new User();
		m.addAttribute("user", u);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Signup");
		return mv;
	}
	@PostMapping("/signin")
	public ModelAndView signin(@ModelAttribute("user") User r,Model m)
	{
		System.out.println(r); 
		ts.addUser(r);
		m.addAttribute("user", r);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Login");
		return mv;
	}
	
	@GetMapping("/liuu")
	public ModelAndView Buses(Model m)
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Succes");
		return mv;
	}
	@GetMapping("/fi")
	public ModelAndView flight(Model m)
	{
		Travel u=new Travel();
		m.addAttribute("user", u);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Flight");
		return mv;
	}
	@PostMapping("/flight")
	public ModelAndView getFlight(@ModelAttribute("user") Travel t,Model m)
	{
		ts.addtravel(t);
		ModelAndView mv=new ModelAndView();
		List<Flight> list=ts.getAllFlights(t.getJourneyfrom(),t.getJourneyto());
		m.addAttribute("user", list);
		mv.setViewName("MainFlight");
		return mv;
	}
	@GetMapping("/tr")
	public ModelAndView train(Model m)
	{
		Travel u=new Travel();
		m.addAttribute("user", u);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Train");
		return mv;
	}
	@PostMapping("/train")
	public ModelAndView getTrain(@ModelAttribute("user") Travel t,Model m)
	{
		ts.addtravel(t);
		ModelAndView mv=new ModelAndView();
		List<Train> list=ts.getTrain(t.getJourneyfrom(),t.getJourneyto());
		m.addAttribute("user", list);
		mv.setViewName("MainTrain");
		return mv;
	}
	@GetMapping("/re")
	public ModelAndView getlast() {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("NewFile");
		return mv;
	}
	@GetMapping("/addt")
	public ModelAndView addTrain(Model m)
	{
		Train t=new Train();
		m.addAttribute("user", t);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("AddTrain");
		return mv;
	}
	@PostMapping("/addtrain")
	public void addTrain(@ModelAttribute("user") Train t,Model m)
	{
		ts.addTrain(t);
	}
	@GetMapping("/addf")
	public ModelAndView addFlight(Model m)
	{
		Flight t=new Flight();
		m.addAttribute("user", t);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("AddFlight");
		return mv;
	}
	@PostMapping("/addflight")
	public void addFlight1(@ModelAttribute("user") Flight t,Model m)
	{
		ts.addFlight(t);
	}
	@GetMapping("/addb")
	public ModelAndView addbus(Model m)
	{
		Bus t=new Bus();
		m.addAttribute("user", t);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("AddBus");
		return mv;
	}
	@PostMapping("/addbus")
	public void addBus(@ModelAttribute("user") Bus t,Model m)
	{
		ts.addBus(t);
	}
	@GetMapping("/viewtrains")
	public ModelAndView viewTrains(Model m)
	{
		ModelAndView mv=new ModelAndView();
		List<Train> list=ts.getTrains();
		m.addAttribute("user", list);
		mv.setViewName("ViewTrain");
		return mv;
	}
	@GetMapping("/viewflights")
	public ModelAndView viewFlights(Model m)
	{
		ModelAndView mv=new ModelAndView();
		List<Flight> list=ts.getAllFlights();
		m.addAttribute("user", list);
		mv.setViewName("ViewFlight");
		return mv;
	}
	@GetMapping("/viewbuses")
	public ModelAndView viewBrains(Model m)
	{
		ModelAndView mv=new ModelAndView();
		List<Bus> list=ts.viewAllBus();
		m.addAttribute("user", list);
		mv.setViewName("ViewBus");
		return mv;
	}
}

