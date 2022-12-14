package com.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.Answer;
import com.exam.model.Questions;
import com.exam.model.User;
import com.exam.repo.AnswerRepo;
import com.exam.repo.QuestionRepo;
import com.exam.repo.UserRepo;

@Service
public class ExamService {

	@Autowired
	UserRepo ur;
	
	@Autowired
	QuestionRepo qr;
	
	@Autowired
	AnswerRepo ar;
	
	public void addUser(User u) {
		ur.save(u);
	}
	
	public String validateUser(User c1)
	{
		User c=ur.findByName(c1.getName());
		System.out.println("in service"+c);
		if(c==null)
			return null;
		else
		return c.getType();
	}
	public void addQuestions(Questions q) {
		qr.save(q);
	}
	public List<Questions> getAllQuestion(String category){
		List<Questions> list=qr.findAllByCategory(category);
		return list;
	}
	
	public void addAnswers(Answer a) {
		ar.save(a);
	}
	
	public List<Answer> getAllAnswers(){
		return ar.findAll();
	}
	public List<Questions> getTheAnswerOfQuestion(String category){
		List<Questions> list=qr.findAllAnswerByCategory(category);
		return list;
	}
}
