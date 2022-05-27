package com.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumerEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerEmployeeApplication.class, args);
	}

	 @Bean
	 public RestTemplate restTemplate()
	 {
	 return new RestTemplate();
	 }
}
