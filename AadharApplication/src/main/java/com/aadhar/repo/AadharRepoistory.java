package com.aadhar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aadhar.pojo.Aadhar;

public interface AadharRepoistory extends JpaRepository<Aadhar, String>{

	public Aadhar findByAadharnumber(String aadharnumber);

}
