package com.json.pojo;

public class Geoprahphy {

	String lat;
	String lng;
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public Geoprahphy(String lat, String lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}
	public Geoprahphy() {
		super();
	}
	@Override
	public String toString() {
		return "Geoprahphy [lat=" + lat + ", lng=" + lng + "]";
	}
	
}
