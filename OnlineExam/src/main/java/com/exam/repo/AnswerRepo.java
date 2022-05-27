package com.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.Answer;

public interface AnswerRepo extends JpaRepository<Answer, Integer> {

}
