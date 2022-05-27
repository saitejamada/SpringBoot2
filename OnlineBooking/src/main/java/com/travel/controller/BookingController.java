package com.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView addJourney(@ModelAttribute("user") Travel t)
	{
		ts.addtravel(t);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("Succes");
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
	
	
}
