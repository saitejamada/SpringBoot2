package com.json.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.json.pojo.User;



@Service
public class RestService {

	RestTemplate  template;

	public RestService(RestTemplate template) {
			super();
			this.template = template;
	}
	public ResponseEntity<User[]> showAllUsers()
	{
	String url="https://jsonplaceholder.typicode.com/users";
	HttpEntity entity=new HttpEntity(null, null);
	ResponseEntity<User[]> response=template.exchange(url,HttpMethod.GET, entity,User[].class);
	return response;
	}
	public User goHome()
	{
		return template.getForObject("https://jsonplaceholder.typicode.com/users", User.class);
	}
}
