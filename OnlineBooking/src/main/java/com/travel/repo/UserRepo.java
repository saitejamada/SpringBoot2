package com.travel.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	
}
