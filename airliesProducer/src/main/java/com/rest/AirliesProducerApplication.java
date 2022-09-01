package com.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.rest.model.User;
import com.rest.repo.UserRepo;

@SpringBootApplication
public class AirliesProducerApplication implements CommandLineRunner {

	@Autowired
	UserRepo ur;
	@Autowired
	BCryptPasswordEncoder bpc;
	public static void main(String[] args) {
		SpringApplication.run(AirliesProducerApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User u=new User();
		u.setUsername("sai");
		u.setPassword(this.bpc.encode("abc"));
		u.setRole("ROLE_NORMAL");
		ur.save(u);
		
		User u1=new User();
		u1.setUsername("admin");
		u1.setPassword(this.bpc.encode("admin"));
		u1.setRole("ROLE_ADMIN");
		ur.save(u1);
		
	}

}
