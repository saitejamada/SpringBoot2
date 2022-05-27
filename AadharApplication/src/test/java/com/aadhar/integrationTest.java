//package com.aadhar;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import java.net.URI;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.util.UriComponents;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import com.aadhar.pojo.Aadhar;
//
//
//
//@SpringBootTest(webEnvironment =WebEnvironment.DEFINED_PORT)
//public class integrationTest {
//
//	 @Autowired
//	 TestRestTemplate template;
//	 @BeforeEach
//	 void setUp() throws Exception {
//	 }
//	 
//	 @Test
//	 public void getAdharTest()
//	 {
//		 String url="http://localhost:8080/aadhar?";
//		 UriComponents builder=UriComponentsBuilder.fromHttpUrl(url).queryParam("aadharnumber","1234").build();
//		 HttpEntity<Aadhar> request=new HttpEntity<Aadhar>(null,null);
//		 ResponseEntity<String> res=template.exchange (builder.toString(), HttpMethod.GET,request,String.class);
//		 System.out.println("Response from the Server"+res);
//		 assertEquals(HttpStatus.OK, res.getStatusCode());
//	 }
//	 
//	 @Test
//	 public void getAllAadharTest() {
//		 
//		 String url="http://localhost:8080/aadhar";
//		 UriComponents builder=UriComponentsBuilder.fromHttpUrl(url).build();
//		 HttpEntity<Aadhar> request=new HttpEntity<Aadhar>(null,null);
//		 ResponseEntity<Aadhar[]> res=template.exchange (builder.toString(), HttpMethod.GET,request,Aadhar[].class);
//		 Aadhar a[]=res.getBody();
//		 System.out.println("Response from the Server"+a);
//		 assertEquals(HttpStatus.OK, res.getStatusCode());
//	 }
//	 
//	 @Test
//	 public void addAadhar() {
//		 
//		 String url="http://localhost:8080/aadhar";
//		 UriComponents builder=UriComponentsBuilder.fromHttpUrl(url).build();
//		 
//		 Aadhar a=new Aadhar("saiteja","124642");
//		 
//		 HttpHeaders headers = new HttpHeaders();
//		 headers.setContentType(MediaType.APPLICATION_JSON);
//		 
//		 HttpEntity<Aadhar> request = new HttpEntity<Aadhar>(a, headers);
//		 
//		 ResponseEntity<Aadhar> response=template.exchange (builder.toString(), HttpMethod.POST,request,Aadhar.class);
//		 assertEquals(HttpStatus.OK,response.getStatusCode());
//	 }
//	
//	 @Test
//	 public void updateAadharTest() {
//	 
//		 String url="http://localhost:8080/aadhar/1234";
//		 UriComponents builder=UriComponentsBuilder.fromHttpUrl(url).build();
//		 HttpHeaders headers = new HttpHeaders();
//		 headers.setContentType(MediaType.APPLICATION_JSON);
//		 Aadhar a=new Aadhar("saitejamada","1234");
//		 HttpEntity<Aadhar> request=new HttpEntity<Aadhar>(a,headers);
//		 ResponseEntity<Aadhar> res=template.exchange (builder.toString(), HttpMethod.PUT,request,Aadhar.class);
//		 assertEquals(HttpStatus.OK,res.getStatusCode());
//		 
//	 }
//	 
//	 @Test
//	 public void deleteAadharTest() {
//		 
//		 String url = "http://localhost:8080/aadhar/1234";
//		 HttpEntity<Aadhar> request = new HttpEntity<Aadhar>(null, null);
//		 ResponseEntity<Void> res = template.exchange(url, HttpMethod.DELETE, request, Void.class);
//		 assertEquals(HttpStatus.OK,res.getStatusCode());
//	 }
//
//
//	
//}
