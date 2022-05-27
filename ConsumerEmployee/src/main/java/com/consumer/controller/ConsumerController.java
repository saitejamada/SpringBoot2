package com.consumer.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.consumer.model.Employee;
import com.consumer.restservice.RestService;

@RestController
public class ConsumerController {

	@Autowired
	RestService rest;
	
	 @GetMapping("/")
	 public String getThirdPartApiData()
	 {
	 return rest.callThirdPartyAPI();	
	 }
	 @GetMapping("/employee/{eid}")
	 public ResponseEntity <Employee> searchEmployee (@PathVariable("eid") int eid)
	 {
	 return rest.searchEmployeeById(eid);
	 }
	 @GetMapping("/employees")
	 public ResponseEntity<Employee[]> showAllstudents()
	 {
	 return rest.showAllEmployees();
	 }
	 @PostMapping(path="/employee")
	 public ResponseEntity <Employee>  addEmployee(@RequestBody Employee e) throws URISyntaxException
	 {
		 return rest.addNewEmployee(e);
	 }
	 @DeleteMapping("/employee/{eid}")
	 public ResponseEntity <Employee> deleteEmp(@PathVariable("eid") int eid) throws URISyntaxException
	 {
		 System.out.println(eid);
		 return rest.deleteEmployee(eid);
	 }
	 @PutMapping("/employee/{eid}")
	 public ResponseEntity <Employee> updateEmployee(@PathVariable("eid") int eid,@RequestBody Employee e) throws URISyntaxException{
		 return rest.updateEmployee(e, eid);
	 }
}
