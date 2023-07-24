package com.erabia.arbahi.bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TransactionBean {
	@Expose
	@SerializedName("activityCode")
	private long activityCode;
	@Expose
	@SerializedName("activityType")
    private String activityType;
	@Expose
	@SerializedName("loyaltyID")
    private String loyaltyID;
	@Expose
	@SerializedName("referenceNumber")
    private String referenceNumber;
	@Expose
	@SerializedName("orderNumber")
    private String orderNumber;
	@Expose
	@SerializedName("points")
    private BigDecimal points;
	@Expose
	@SerializedName("refActivityCode")
    private long refActivityCode;
	@Expose
	@SerializedName("userCreate")
    private String userCreate;
	@Expose
	@SerializedName("createDate")
    private LocalDateTime createDate;
	
	public long getActivityCode() {
		return activityCode;
	}
	public void setActivityCode(long activityCode) {
		this.activityCode = activityCode;
	}
	public String getActivityType() {
		return activityType;
	}
	public void setActivityType(String activityType) {	
		this.activityType = activityType;
	}
	public String getLoyaltyID() {
		return loyaltyID;
	}
	public void setLoyaltyID(String loyaltyID) {
		this.loyaltyID = loyaltyID;
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
	public BigDecimal getPoints() {
		return points;
	}
	public void setPoints(BigDecimal points) {
		this.points = points;
	}
	public long getRefActivityCode() {
		return refActivityCode;
	}
	public void setRefActivityCode(long refActivityCode) {
		this.refActivityCode = refActivityCode;
	}
	public String getUserCreate() {
		return userCreate;
	}
	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	
	
}
