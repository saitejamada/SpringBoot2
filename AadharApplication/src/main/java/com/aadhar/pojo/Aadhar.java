package com.aadhar.pojo;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Aadhar {


	String name;
	@Id
	String aadharnumber;
	@Lob
	byte[] image;
	
	public Aadhar(String name, String aadharnumber, byte[] image) {
		super();
		this.name = name;
		this.aadharnumber = aadharnumber;
		this.image = image;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAadharnumber() {
		return aadharnumber;
	}
	public void setAadharnumber(String aadharnumber) {
		this.aadharnumber = aadharnumber;
	}
	
	
	
	public Aadhar() {
		super();
	}
	@Override
	public String toString() {
		return "Aadhar [name=" + name + ", aadharnumber=" + aadharnumber + "]";
	}	
}
