package com.travel.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.model.Travel;
import com.travel.model.User;

public interface Travelrepo extends JpaRepository<Travel, Integer> {

}
