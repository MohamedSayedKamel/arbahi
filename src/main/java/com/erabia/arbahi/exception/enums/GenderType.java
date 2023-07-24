package com.erabia.arbahi.exception.enums;

public enum GenderType {
	MALE("Male"),FEMALE("Female");
	
	private String code;

	private GenderType(String code) {
		
		this.code=code;
	}

	public String getCode() {
		return code;
	}
}
