package com.question.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userTypeId;
	private String userTypeName;

	public UserType() {
	}

	public int getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(byte userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}
	
	

}
