package com.consumer.restservice;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.consumer.model.Employee;

@Service
public class RestService {

	RestTemplate  template;

	public RestService(RestTemplate template) {
			super();
			this.template = template;
	}
	public String callThirdPartyAPI()
	{
		//return template.getForObject("https://jsonplaceholder.typicode.com/todos/1",Strin
		return template.getForObject("http://localhost:8080/", String.class);
	}
	public ResponseEntity<Employee> searchEmployeeById(int sid)
	{
		String url="http://localhost:8080/employee/"+sid;
		ResponseEntity<Employee> entity=template.getForEntity(url, Employee.class);
		Employee  s=entity.getBody();
		System.out.println("The Employee details"+s);
		return entity;
	}
	 public ResponseEntity<Employee[]> showAllEmployees()
	 {
	 String url="http://localhost:8080/employees";
	 HttpEntity entity=new HttpEntity(null, null);
	 ResponseEntity<Employee[]> response=template.exchange(url,HttpMethod.GET, entity,Employee[].class);
	 return response;
	 }
	 public ResponseEntity<Employee> addNewEmployee (Employee s) throws URISyntaxException{
	 URI uri=new URI("http://localhost:8080/employee");
	 HttpEntity<Employee> entity=new HttpEntity<Employee>(s,null);
	 ResponseEntity<Employee> response=template.exchange(uri,HttpMethod.POST, entity,Employee.class);
	 return response;
	 }
	public ResponseEntity<Employee> deleteEmployee(int sid) throws URISyntaxException {
		URI uri=new URI("http://localhost:8080/employee/"+sid);
		ResponseEntity<Employee> entity=template.getForEntity(uri,Employee.class);
		Employee e=entity.getBody();
		HttpEntity<Employee> entity1=new HttpEntity<Employee>(e,null);
		ResponseEntity<Employee> response=template.exchange(uri,HttpMethod.DELETE,entity,Employee.class);
		return response;
	}
	public ResponseEntity<Employee> updateEmployee (Employee s,int eid) throws URISyntaxException{
		
		URI uri=new URI("http://localhost:8080/employee/"+eid);
		 HttpEntity<Employee> entity=new HttpEntity<Employee>(s,null);
		 ResponseEntity<Employee> response=template.exchange(uri,HttpMethod.PUT, entity,Employee.class);
		 return response;
	}
	
}
