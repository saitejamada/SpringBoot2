package com.exam.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exam.model.Answer;
import com.exam.model.Questions;
import com.exam.model.User;
import com.exam.service.ExamService;

@Controller
public class ExamController {

	@Autowired
	ExamService es;
	
	
	@RequestMapping("/hi")
	public String goHome(Model  m) {
		User u=new User();
		m.addAttribute("user",u);
		return "Signup";
	}
	
	@RequestMapping("/signup")
	public String login(@ModelAttribute("user") User user,Model m) {
		es.addUser(user);
		m.addAttribute("user",user);
		return "Login";
	}
	
	@RequestMapping("/login")
	public  String validate(@ModelAttribute("user") User u,Model m) {
		
		String type=es.validateUser(u);
		if(type.equals("user")){
			List<Questions> list=es.getAllQuestion("java");
			m.addAttribute("user",list);
			Answer a=new Answer();
			m.addAttribute("java", a);
			return "HomePage";
		}
		else {
			return "Admin";	
		}
	}
	@RequestMapping("/addquestion")
	public String addQuestion(Model m) {
		Questions q=new Questions();
		m.addAttribute("user", q);
		return "AddQuestion";
		
	}
	@RequestMapping("/savequestion")
	public String saveQuestion(@ModelAttribute("user") Questions q,Model m) {
		es.addQuestions(q);
		m.addAttribute("msg", "added successfully");
		return "AddQuestion";
	}
	@RequestMapping("/pi")
	public String goPyhton(Model m) {
		List<Questions> list=es.getAllQuestion("python");
		m.addAttribute("user",list);
		Answer a=new Answer();
		m.addAttribute("py", a);
		return "Python";
	}
	@RequestMapping("/ja")
	public String goJava(Model m) {
		List<Questions> list=es.getAllQuestion("java");
		m.addAttribute("user",list);
		Answer a=new Answer();
		m.addAttribute("java", a);
		return "HomePage";
	}
	@RequestMapping("/testjava")
	public String validateJava(@ModelAttribute("java")Answer a,Model m) {
		int score =0;int i=1;
		es.addAnswers(a);
		List<Questions> list1=es.getAllQuestion("java");
		List<Answer> list2=es.getAllAnswers();
		System.out.println(list2);
		for (Questions q : list1) {
			String s=q.getAnswer();
			System.out.println(s);
			for (Answer answer : list2) {
				if(i==1)
				{
					if(answer.getAnswer1().equals(s))
						score ++;
				}
				else if(i==2) {
					if(answer.getAnswer2().equals(s))
						score ++;
				}
				else if(i==3) {
					if(answer.getAnswer3().equals(s))
						score ++;
				}
				else if(i==4) {
					if(answer.getAnswer4().equals(s))
						score ++;
				}
				i++;	
			}
	
				
			}
		
		m.addAttribute("msg",score);
		return "Final";
		
	}
	@RequestMapping("/testpy")
	public String validatePyhton(@ModelAttribute("py")Answer a,Model m) {
		int score =0;
		int i=1;
		es.addAnswers(a);
		List<Questions> list1=es.getAllQuestion("python");
		List<Answer> list2=es.getAllAnswers();
		System.out.println("List 1 is empty"+list1.isEmpty());
		System.out.println("List 2 is empty"+list2.isEmpty());
		System.out.println(list2);
		for (Questions q : list1) {
			String s=q.getAnswer();
				for (Answer answer : list2) {
					if(i==1)
					{
						if(answer.getAnswer1().equals(s))
							score ++;
					}
					else if(i==2) {
						if(answer.getAnswer2().equals(s))
							score ++;
					}
					else if(i==3) {
						if(answer.getAnswer3().equals(s))
							score ++;
					}
					else if(i==4) {
						if(answer.getAnswer4().equals(s))
							score ++;
					}
						
				}
				i++;
		}
		m.addAttribute("msg",score);
		return "Final";
		
	}
}
