package com.aadhar.service;

import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aadhar.exception.AadharException;
import com.aadhar.pojo.Aadhar;
import com.aadhar.repo.AadharRepoistory;



@Service
public class AadharService {

	@Autowired
	AadharRepoistory ar;
	
	Logger logger=LoggerFactory.getLogger("AadharController.class");
	
	
	
	public AadharService(AadharRepoistory ar) {
		// TODO Auto-generated constructor stub
		this.ar=ar;
	}

	public Aadhar saveAadhar(Aadhar a) {
		
		logger.info("In Service class save addhar method and saving the aadhar");
		Aadhar a1= ar.save(a);
		
		 if(a1==null) {
			logger.warn("unable to save Error occured");
			return null;
			}
		else
		{
			logger.info("saved successfully "+a);
			return a1;
		}
		
		
	}
	
	public Aadhar updateAadhar(Aadhar a,String aadharnumber) {
		logger.info("In Service class update addhar method and update the aadhar");
		Aadhar a1=ar.findByAadharnumber(aadharnumber);
		if(a1==null) {
			logger.warn("no person is found with aadharnumber::"+aadharnumber);
			throw new AadharException("no peron with aadhar"+aadharnumber);
			}
		else
		{
			logger.info("person id found return control to service");
			return ar.save(a);
		}
		
	}
	public Aadhar getAadharDetail(String aadharnumber) {
		logger.info("In Service class get addhar method interacting with repo");
		Aadhar a1=ar.findByAadharnumber(aadharnumber);
		if(a1==null) {
			logger.warn("no person is found with aadharnumber::"+aadharnumber);
			throw new AadharException("no peron with aadhar"+aadharnumber);
			}
		else
		{
			logger.info("person id found return control to service");
			return a1;
		}
	}
	public List<Aadhar> getAllAadhardetails(){
		logger.info("In Service class get all addhar method interacting with repo and going to invoke findall method");
		return ar.findAll();
	}
	public void deleteAadhar(String aadharnumber) {
		logger.info("In Service class delete addhar method interacting with repo and going to invoke delete	 method");
		Aadhar a1=ar.findByAadharnumber(aadharnumber);
		if(a1==null) {
			logger.warn("no person is found with aadharnumber::"+aadharnumber);
			throw new AadharException("no peron with aadhar"+aadharnumber);
			}
		else
		{
			logger.info("person id found return control to service");
			ar.delete(a1);
		}
		
	}
}
