package com.converter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="currency")
public class Currency {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	int currency1;
	String currencyfrom;
	
	public String getCurrencyfrom() {
		return currencyfrom;
	}
	public void setCurrencyfrom(String currencyfrom) {
		this.currencyfrom = currencyfrom;
	}
	String currencyname;
	
	public String getCurrencyname() {
		return currencyname;
	}
	public void setCurrencyname(String currencyname) {
		this.currencyname = currencyname;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCurrency1() {
		return currency1;
	}
	public void setCurrency1(int currency1) {
		this.currency1 = currency1;
	}
	
	public Currency(long id, int currency1) {
		super();
		this.id = id;
		this.currency1 = currency1;
		
	}
	public Currency() {
		super();
	}
	@Override
	public String toString() {
		return "Currency [id=" + id + ", currency1=" + currency1 + ", currencyname=" + currencyname + "]";
	}
	
}
