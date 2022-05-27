package com.travel.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flight")
public class Flight {

	@Id
	int flightid;
	String name;
	String flightfrom;
	String flightto;
	int price;
	public int getFlightid() {
		return flightid;
	}
	public void setFlightid(int flightid) {
		this.flightid = flightid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFlightfrom() {
		return flightfrom;
	}
	public void setFlightfrom(String flightfrom) {
		this.flightfrom = flightfrom;
	}
	public String getFlightto() {
		return flightto;
	}
	public void setFlightto(String flightto) {
		this.flightto = flightto;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
