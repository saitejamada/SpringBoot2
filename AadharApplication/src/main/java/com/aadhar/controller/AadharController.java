package com.aadhar.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.aadhar.pojo.Aadhar;
import com.aadhar.service.AadharService;

@RestController
public class AadharController {
	
	
	Logger logger=LoggerFactory.getLogger("AadharController.class");

	@Autowired
	AadharService as;
	

	@RequestMapping("/add")
	public ModelAndView addUser(Model m) {
		Aadhar a=new Aadhar();
		m.addAttribute("user", a);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("AddAadhar");
		return mv;
		
	}
	@RequestMapping("/vi")
	public ModelAndView viewUser(Model m) {
		Aadhar a=new Aadhar();
		m.addAttribute("user", a);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("ViewOne");
		return mv;
	}
	
	@GetMapping("/home")
	public String home() {
		
		logger.trace("Information is traced");
		logger.info("Home Get mapping   Information Generated");
		logger.debug("Application is in DEBUG Mode");
		logger.warn("Generating Warning .....");
		return "Helloo From Addhar";
		
	}
	@PostMapping("/aadhar")
	public Aadhar saveAddhar(@RequestParam("name")String name,@RequestParam("aadharnumber")String no,@RequestParam("image")MultipartFile file) throws IOException {
		logger.info("in post mapping  save aadhar method");
		logger.info("control going to the Service ");
		byte [] image=file.getBytes();
		Aadhar a=new Aadhar(name,no,image);
		Aadhar a1= as.saveAadhar(a);
		logger.debug("in controller and aadhar object saved succesfully");
		logger.info("Sending response to the client");
		return a1;
		
	}
	@PutMapping(path="/aadhar/{aadharnumber}",produces = MediaType.IMAGE_JPEG_VALUE)
	public Aadhar updateAadhar(@RequestBody Aadhar a,@PathVariable("aadharnumber") String aadharnumber) {
		logger.info("in put mapping  update aadhar method control is going to aadhar");
		Aadhar a1=as.updateAadhar(a, aadharnumber);
		logger.debug("in controller and aadhar object updated succesfully");
		logger.info("Sending response to the client");
		return a1;
	}
	@GetMapping("/aadhar/{aadharnumber}")
	public ModelAndView getAadhar(@RequestParam("aadharnumber") String aadharnumber,Model m) throws UnsupportedEncodingException {
		
		logger.info("in get mapping  get aadhar method control is going to aadhar");
		Aadhar a1=as.getAadharDetail(aadharnumber);
		logger.debug("in controller and aadhar object retrived succesfully");
		logger.info("Sending response to the client");
		m.addAttribute("name", a1.getName());
		m.addAttribute("aadharnumber", a1.getAadharnumber());
		byte[] encode = java.util.Base64.getEncoder().encode(a1.getImage());
        m.addAttribute("image", new String(encode, "UTF-8"));
		ModelAndView mv=new ModelAndView();
		mv.setViewName("ViewOfOne");
		return mv;
	
	}
	@GetMapping("/aadhar")
	public List<Aadhar> getAllAadhar(){
		logger.info("in get mapping  get All aadhar method control is going to aadhar");
		List<Aadhar> list= as.getAllAadhardetails();
		logger.debug("in controller and aadhar objects retrived succesfully");
		logger.info("Sending response to the client");
		return list;
	}
	@DeleteMapping("/aadhar/{aadharnumber}")
	public String deleteAadhar(@PathVariable("aadharnumber") String aadharnumber) {
		logger.info("in delete mapping  delete aadhar method control is going to aadhar");
		as.deleteAadhar(aadharnumber);
		logger.debug("in controller and aadhar objects deleted succesfully");
		logger.info("Sending response to the client");
		return "Deleted";
	}
}
