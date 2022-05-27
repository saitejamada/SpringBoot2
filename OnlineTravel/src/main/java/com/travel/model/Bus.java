package com.travel.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bustravel")
public class Bus {

	@Id
	int busid;
	@Override
	public String toString() {
		return "Bus [busid=" + busid + ", name=" + name + ", busfrom=" + busfrom + ", busto=" + busto + ", price="
				+ price + "]";
	}
	String name;
	String busfrom;
	String busto;
	int price;
	public int getBusid() {
		return busid;
	}
	public void setBusid(int busid) {
		this.busid = busid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBusfrom() {
		return busfrom;
	}
	public void setBusfrom(String busfrom) {
		this.busfrom = busfrom;
	}
	public String getBusto() {
		return busto;
	}
	public void setBusto(String busto) {
		this.busto = busto;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
