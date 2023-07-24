package com.erabia.arbahi.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerInfoBean {
	@Expose
	@SerializedName("loyaltyID")
   private String loyaltyID;
	@Expose
	@SerializedName("loyaltyName")
   private String loyaltyName;
	@Expose
	@SerializedName("firstName")
   private String firstName;
	@Expose
	@SerializedName("lastName")
   private String lastName;
	@Expose
	@SerializedName("phone1")
   private String phone1;
	@Expose
	@SerializedName("email")
   private String email;
	@Expose
	@SerializedName("gender")
   private String gender;
	@Expose
	@SerializedName("city")
   private String city;
	@Expose
	@SerializedName("nationality")
   private String nationality;
   
public String getLoyaltyID() {
	return loyaltyID;
}
public void setLoyaltyID(String loyaltyID) {
	this.loyaltyID = loyaltyID;
}
public String getLoyaltyName() {
	return loyaltyName;
}
public void setLoyaltyName(String loyaltyName) {
	this.loyaltyName = loyaltyName;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getPhone1() {
	return phone1;
}
public void setPhone1(String phone1) {
	this.phone1 = phone1;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getNationality() {
	return nationality;
}
public void setNationality(String nationality) {
	this.nationality = nationality;
}

}
