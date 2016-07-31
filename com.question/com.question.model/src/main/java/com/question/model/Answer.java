package com.question.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long answerId;
	private String content;
	@ManyToOne
	@JsonIgnore
	private Question question;
//	private boolean isCorrect;
	@Transient
	private User user;
	@Transient
	private List<Rate> rateList;

	public Answer() {
	}

	public long getAnswerId() {
		return answerId;
	}

	public List<Rate> getRateList() {
		return rateList;
	}

	public void setRateList(List<Rate> rateList) {
		this.rateList = rateList;
	}

	public void setAnswerId(long answerId) {
		this.answerId = answerId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

//	public boolean isCorrect() {
//		return isCorrect;
//	}
//
//	public void setCorrect(boolean isCorrect) {
//		this.isCorrect = isCorrect;
//	}

}
