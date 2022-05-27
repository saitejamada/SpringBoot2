package com.travel.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usertravel")
public class User{

	@Id
	int userid;
	String password;
	String type;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public User(int userid, String password, String type) {
		super();
		this.userid = userid;
		this.password = password;
		this.type = type;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", password=" + password + ", type=" + type + "]";
	}
	public User() {
		super();
	}
}
