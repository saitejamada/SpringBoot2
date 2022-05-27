package com.travel.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "train")
public class Train {

	@Id
	int trainid;
	String trainname;
	String trainfrom;
	String trainto;
	int price;
	public int getTrainid() {
		return trainid;
	}
	public void setTrainid(int trainid) {
		this.trainid = trainid;
	}
	public String getTrainname() {
		return trainname;
	}
	public void setTrainname(String trainname) {
		this.trainname = trainname;
	}
	public String getTrainfrom() {
		return trainfrom;
	}
	public void setTrainfrom(String trainfrom) {
		this.trainfrom = trainfrom;
	}
	public String getTrainto() {
		return trainto;
	}
	public void setTrainto(String trainto) {
		this.trainto = trainto;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
