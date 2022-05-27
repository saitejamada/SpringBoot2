package com.exam.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.exam.model.Questions;

public interface QuestionRepo extends JpaRepository<Questions, Integer> {

	List<Questions> findAllByCategory(String category);
	
	
	List<Questions> findAllAnswerByCategory(String category);

}
