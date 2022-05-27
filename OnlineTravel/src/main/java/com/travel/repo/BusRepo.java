package com.travel.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.model.Bus;


public interface BusRepo extends JpaRepository<Bus, Integer> {

	List<Bus> findBybusfrom(String from);

}
