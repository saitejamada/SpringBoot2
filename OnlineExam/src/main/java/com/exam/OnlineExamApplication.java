package com.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.model.Questions;
import com.exam.service.ExamService;

@SpringBootApplication
public class OnlineExamApplication implements CommandLineRunner {

	@Autowired
	ExamService es;
	public static void main(String[] args) {
		SpringApplication.run(OnlineExamApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Questions q=new Questions("who invented java","java","james gosling","rr martin","jkrowling","none","a");
		es.addQuestions(q);
		Questions q1=new Questions(" java is a ","java","procedure oriented","object oriented","both","none","b");
		es.addQuestions(q1);
		Questions q2=new Questions(" java is invented in ","java","1992","1993","1994","1995","d");
		es.addQuestions(q2);
		Questions q3=new Questions(" java is initially named after ","java","tea","coffee","oak tree","none","c");
		es.addQuestions(q3);

	}

}
