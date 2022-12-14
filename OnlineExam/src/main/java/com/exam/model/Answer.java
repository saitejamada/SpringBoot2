package com.exam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "answerexam")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int aid;
	String answer1;
	String answer2;
	String answer3;
	String answer4;
	String answer5;
	@Override
	public String toString() {
		return "Answer [aid=" + aid + ", answer1=" + answer1 + ", answer2=" + answer2 + ", answer3=" + answer3
				+ ", answer4=" + answer4 + ", answer5=" + answer5 + "]";
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	public String getAnswer4() {
		return answer4;
	}
	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}
	public String getAnswer5() {
		return answer5;
	}
	public void setAnswer5(String answer5) {
		this.answer5 = answer5;
	}
	
}
