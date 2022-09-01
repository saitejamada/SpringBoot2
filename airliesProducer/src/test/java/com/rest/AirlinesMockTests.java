package com.rest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Stubbing;
import org.springframework.boot.test.context.SpringBootTest;

import com.rest.exception.AirlinePassengerException;
import com.rest.model.Airlines;
import com.rest.model.Passengers;
import com.rest.repo.AirLineRepo;
import com.rest.repo.PassengersRepo;

@SpringBootTest
public class AirlinesMockTests {

	@Mock
	AirLineRepo ar;
	@Mock
	PassengersRepo pr;
	
	@Test
	void testaddAirline() {
		Airlines a=new Airlines("198u","jetairways","India","https://jetairwayslogo.com","fly high","Hyderabad","www.jetairways.com","1996");;
		when(ar.save(a)).thenReturn(a);
		assertEquals(a, ar.save(a));
	}
	@Test
	void testViewAirlines() {
		Optional<Airlines> a=Optional.of(new Airlines("198u","jetairways","India","https://jetairwayslogo.com","fly high","Hyderabad","www.jetairways.com","1996"));;
		doReturn(a).when(ar).findById("198u");
		Optional<Airlines> a1=ar.findById("198u");
		assertNotNull(a1);
	}
	@Test
	void testViewAllAirlines() {
		@SuppressWarnings("unchecked")
		List<Airlines> list=Mockito.mock(List.class);
		list.add(new Airlines("1234","air india","india","https://www.google.com/airindialog.png","fly high","mumbai","www.airindia.com","1969"));
		list.add(new Airlines("12349","jetairwys","india","https://www.google.com/jetairwayslog.png","above skies","mumbai","www.jetindia.com","1995"));
		list.add(new Airlines("1235","air asia","india","https://www.google.com/airasialog.png","flying made easy","banglore","www.airasia.com","1989"));
		when(ar.findAll()).thenReturn(list);
		List<Airlines> list1=ar.findAll();
		assertEquals(list, list1);
	}
	@Test
	void testUpdateAirlines() {
		Optional<Airlines> a=Optional.of(new Airlines("198u","jetairways","India","https://jetairwayslogo.com","fly high","Hyderabad","www.jetairways.com","1996"));;
		Optional<Airlines> a1=Optional.of(new Airlines("198u","jetindia","India","https://jetairwayslogo.com","fly high","Hyderabad","www.jetairways.com","1996"));;
		when(ar.findById("198u")).thenReturn(a1);
		assertNotEquals(a1, ar.findById("198u").get());
	}
	@Test
	void testDeleteAirline() {
		Airlines a1=new Airlines("198u","jetindia","India","https://jetairwayslogo.com","fly high","Hyderabad","www.jetairways.com","1996");
		verify(ar,times(0)).deleteById("198u");
	}
	
	@Test
	void testAddPassenger() {
		Airlines a1=new Airlines("198u","jetindia","India","https://jetairwayslogo.com","fly high","Hyderabad","www.jetairways.com","1996");
		Passengers p=new Passengers("1112","johnny",12,a1,"jnkjn");
		when(pr.save(p)).thenReturn(p);
		assertEquals(p, pr.save(p));
	}
	@Test
	void testViewPassenger() {
		Airlines a1=new Airlines("198u","jetindia","India","https://jetairwayslogo.com","fly high","Hyderabad","www.jetairways.com","1996");
		Optional<Passengers> p=Optional.of(new Passengers("1112","johnny",12,a1,"jnkjn"));
		doReturn(p).when(ar).findById("1112");
		assertEquals(p,ar.findById("1112"));
	}
	@Test
	void testViewAllPassengers() {
		List<Passengers> list=Mockito.mock(List.class);
		Airlines a1=new Airlines("198u","jetindia","India","https://jetairwayslogo.com","fly high","Hyderabad","www.jetairways.com","1996");
		list.add(new Passengers("1112","johnny",12,a1,"jnkjn"));
		list.add(new Passengers("1212","johnny",12,a1,"jnkjn"));
		when(pr.findAll()).thenReturn(list);
		assertEquals(list, pr.findAll());
	}
	@Test
	void testUpdatePassenger() {
		Airlines a=new Airlines("198u","jetairways","India","https://jetairwayslogo.com","fly high","Hyderabad","www.jetairways.com","1996");
		Optional<Passengers> p=Optional.of(new Passengers("1112","johnny",12,a,"jnkjn"));
		Optional<Passengers> p1=Optional.of(new Passengers("1112","johnny Depp",12,a,"jnkjn"));;
		when(pr.findById("1112")).thenReturn(p1);
		assertNotEquals(p1, pr.findById("1112").get());
	}
	@Test
	void testDeletePassenger() {
		Airlines a=new Airlines("198u","jetairways","India","https://jetairwayslogo.com","fly high","Hyderabad","www.jetairways.com","1996");
		Passengers p=new Passengers("1112","johnny",12,a,"jnkjn");
		verify(pr,times(0)).deleteById("1112");
	}
	@Test
	void testViewPassengerNotExist() {
		AirlinePassengerException a=new AirlinePassengerException("no id peresent");
		when(pr.findById("1112")).thenThrow(a);
		ar.findById("1112");

	}
}
