package com.rest.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "passengers")
public class Passengers {
	@Id
	private String id;
	private String name;
	private int trips;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn
	private Airlines airline;
	private String v;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTrips() {
		return trips;
	}
	public void setTrips(int trips) {
		this.trips = trips;
	}
	public Airlines getAirline() {
		return airline;
	}
	public void setAirline(Airlines airline) {
		this.airline = airline;
	}
	public String getV() {
		return v;
	}
	public void setV(String v) {
		this.v = v;
	}
	public Passengers(String id, String name, int trips, Airlines airline, String v) {
		super();
		this.id = id;
		this.name = name;
		this.trips = trips;
		this.airline = airline;
		this.v = v;
	}
	public Passengers() {
		super();
	}
	@Override
	public String toString() {
		return "Passengers [id=" + id + ", name=" + name + ", trips=" + trips + ", airline=" + airline + ", v=" + v
				+ "]";
	}	
}
