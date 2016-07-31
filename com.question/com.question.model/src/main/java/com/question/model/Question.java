package com.question.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long questionId;

	private String header;
	@Column(length=500)
	private String content;
	private int questionPoint;
	@OneToMany(mappedBy="question")
	private List<Answer> answerList;

	// private User user;
	public Question(String header, String content) {
		this.header = header;
		this.content = content;
	}

	public Question() {
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getQuestionPoint() {
		return questionPoint;
	}

	public void setQuestionPoint(int questionPoint) {
		this.questionPoint = questionPoint;
	}

	 public List<Answer> getAnswerList() {
	 return answerList;
	 }
	
	 public void setAnswerList(List<Answer> answerList) {
	 this.answerList = answerList;
	 }
	
	// public User getUser() {
	// return user;
	// }
	//
	// public void setUser(User user) {
	// this.user = user;
	// }
}
