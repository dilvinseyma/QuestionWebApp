package com.question.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Rate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rateId;
	@Transient
	private RateStatus rateStatus;
	@Transient
	private Answer answer;
	@Transient
	private User user;

	public Rate() {
	}

	public int getRateId() {
		return rateId;
	}

	public void setRateId(int rateId) {
		this.rateId = rateId;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public RateStatus getRateStatus() {
		return rateStatus;
	}

	public void setRateStatus(RateStatus rateStatus) {
		this.rateStatus = rateStatus;
	}

}
