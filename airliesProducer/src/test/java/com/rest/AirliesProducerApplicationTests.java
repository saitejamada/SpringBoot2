package com.rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.rest.model.Airlines;
import com.rest.model.Passengers;
import com.rest.repo.AirLineRepo;

@SpringBootTest
class AirliesProducerApplicationTests {

	
	@Test
	void contextLoads() {
	}
	
	Airlines a1,a2,a3;
	Passengers p1,p2,p3;
	
	@BeforeEach
	void setUpAirline() throws Exception{
		 a1=new Airlines("198u","jetairways","India","https://jetairwayslogo.com","fly high","Hyderabad","www.jetairways.com","1996");
		 a2=new Airlines("209u","indigojetways","India","https://www.indigojetlogo.com","reach sky","Delhi","www.indigoways.com","1990");
		 p1=new Passengers("19967","saiteja",150,a1,"165546");
		 p2=new Passengers("20165","pavan",125,a2,"46546");
		
	}
	
	@Test
	void testFindAirline()
	{
		assertNotNull(a1);
	}
	
	@Test
	void testAirlines()
	{
		assertNotEquals(a1,a2);
	}
	
	@Test
	void testCompareAirlinesById()
	{
		assertNotEquals(a1.getId(),a2.getId());
	}
	
	@Test
	void testComparePassengers()
	{
		assertNotEquals(p1,p2);
	}
	
	@Test
	void  testFindPassenger()
	{
		assertNotNull(p1);
	}
	
	@Test
	void testFindPassengerId()
	{
		assertTrue(p1.getId().equals("19967"));
	}	
	
	@Test
	void testComparePassengerObjects()
	{
		assertNotSame(p2,p3);
	}
	
	@Test
	void testAirlineObject()
	{
		assertNotSame(a2,a3);
	}
	
	@Test
	void testFindAirlineId()
	{
		assertTrue(a1.getId().equals("198u"));
	}
	


}
