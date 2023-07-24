package com.erabia.arbahi.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateCustomerRequest extends CustomerInfoRequest {
	@Expose
	@SerializedName("loyaltyID")
	private String loyaltyID;
	

	public UpdateCustomerRequest(String loyaltyID,String loyaltyName, String firstName, String lastName, String phone1, String email,
			String gender, String city, String nationality) {
		super(loyaltyName, firstName, lastName, phone1, email, gender, city, nationality);
		this.loyaltyID = loyaltyID;
	}
	public String getLoyaltyID() {
		return loyaltyID;
	}

	public void setLoyaltyID(String loyaltyID) {
		this.loyaltyID = loyaltyID;
	}
}
