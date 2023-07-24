package com.erabia.arbahi.exception.enums;

public enum ActivityType {
	REDEEM("Redeem"), 
	ADD_POINTS_REVERSE("Add Points / Reverse"), 
	//REVERSE(""), 
	EXPIRY("Expiry"), 
	SALES("Sales"), 
	RETURN("Return");

	private String code;

	private ActivityType(String code) {

		this.code = code;
	}

	public String getCode() {
		return code;
	}

}
