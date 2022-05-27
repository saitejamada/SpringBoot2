package com.travel.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "travel")
public class Travel {
	
	@Id
	int travelid;
	String journeyfrom;
	String journeyto;
	Date jouneydate;
	public int getTravelid() {
		return travelid;
	}
	public void setTravelid(int travelid) {
		this.travelid = travelid;
	}
	public String getJourneyfrom() {
		return journeyfrom;
	}
	public void setJourneyfrom(String journeyfrom) {
		this.journeyfrom = journeyfrom;
	}
	public String getJourneyto() {
		return journeyto;
	}
	public void setJourneyto(String journeyto) {
		this.journeyto = journeyto;
	}
	public Date getJouneydate() {
		return jouneydate;
	}
	public void setJouneydate(Date jouneydate) {
		this.jouneydate = jouneydate;
	}
	public Travel(int travelid, String journeyfrom, String journeyto, Date jouneydate) {
		super();
		this.travelid = travelid;
		this.journeyfrom = journeyfrom;
		this.journeyto = journeyto;
		this.jouneydate = jouneydate;
	}
	public Travel() {
		super();
	}
	@Override
	public String toString() {
		return "Travel [travelid=" + travelid + ", journeyfrom=" + journeyfrom + ", journeyto=" + journeyto
				+ ", jouneydate=" + jouneydate + "]";
	}
	
}
