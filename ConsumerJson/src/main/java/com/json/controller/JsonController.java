package com.json.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.json.pojo.User;
import com.json.service.RestService;

@RestController
public class JsonController {

	@Autowired
	RestService rest;
	
	@GetMapping("/users")
	public ResponseEntity<User[]> getAllUser()
	{
	return rest.showAllUsers();
	}
	@GetMapping("/hi")
	public User home() {
		return rest.goHome();
	}
}
