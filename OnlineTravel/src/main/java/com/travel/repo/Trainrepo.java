package com.travel.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.model.Train;

public interface Trainrepo extends JpaRepository<Train, Integer> {

	List<Train> findByTrainfromAndTrainto(String from,String to);
}
