package com.rest.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.model.User;



public interface UserRepo extends JpaRepository<User,Integer> {

	public User findByUsername(String username);

}
