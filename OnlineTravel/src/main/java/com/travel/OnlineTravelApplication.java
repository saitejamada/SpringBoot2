package com.travel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.travel.model.Bus;
import com.travel.model.Flight;
import com.travel.model.Train;
import com.travel.service.TravelSerevice;

@SpringBootApplication
public class OnlineTravelApplication implements CommandLineRunner {

	@Autowired
	TravelSerevice ts;
	
	public static void main(String[] args) {
		SpringApplication.run(OnlineTravelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Bus b=new Bus();
		b.setBusid(111);b.setName("panduranga");b.setBusfrom("hyderabad");b.setBusto("nizmamabad");b.setPrice(600);
		ts.addBus(b);
		Bus b1=new Bus();
		b1.setBusid(112);b1.setName("orange");b1.setBusfrom("nizamabad");b1.setBusto("hyderabad");b1.setPrice(500);
		ts.addBus(b1);
		
		Flight f=new Flight();f.setFlightid(1123);f.setName("spicyjet");f.setFlightfrom("hyderabad");f.setFlightto("goa");f.setPrice(2500);
		Flight f1=new Flight();f1.setFlightid(111234);
		f1.setName("air india");
		f1.setFlightfrom("hyderabad");
		f1.setFlightto("goa");
		f1.setPrice(3300);
		ts.addFlight(f);ts.addFlight(f1);
		
		Train t=new Train();Train t1=new Train();
		t.setTrainid(12011);t.setTrainname("Devagiiri");t.setTrainfrom("hyderabad");t.setTrainto("nizamabad");t.setPrice(210);
		ts.addTrain(t);
		
		t1.setTrainid(121211);t1.setTrainname("Ajantha");t1.setTrainfrom("hyderabad");t1.setTrainto("manmad");t1.setPrice(510);
		ts.addTrain(t1);

	}

}
