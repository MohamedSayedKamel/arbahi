package com.erabia.arbahi.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerRedeemRequest {
	@Expose
	@SerializedName("loyaltyId")
	private String loyaltyId;
	@Expose
	@SerializedName("pointsAmount")
	private double pointsAmount;
	@Expose
	@SerializedName("referenceNumber")
	private String referenceNumber;
	@Expose
	@SerializedName("orderNumber")
	private String orderNumber;
	
	public CustomerRedeemRequest(String loyaltyId, double pointsAmount, String referenceNumber, String orderNumber) {
		super();
		this.loyaltyId = loyaltyId;
		this.pointsAmount = pointsAmount;
		this.referenceNumber = referenceNumber;
		this.orderNumber = orderNumber;
	}
	public String getLoyaltyId() {
		return loyaltyId;
	}
	public void setLoyaltyId(String loyaltyId) {
		this.loyaltyId = loyaltyId;
	}
	public double getPointsAmount() {
		return pointsAmount;
	}
	public void setPointsAmount(double pointsAmount) {
		this.pointsAmount = pointsAmount;
	}
	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
}
