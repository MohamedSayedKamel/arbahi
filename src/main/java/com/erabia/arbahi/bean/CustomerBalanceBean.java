package com.erabia.arbahi.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerBalanceBean {
	@Expose
	@SerializedName("loyaltyId")
	 private String loyaltyId;
	@Expose
	@SerializedName("balancePoint")
     private long balancePoint;
	@Expose
	@SerializedName("balanceAmount")
     private long balanceAmount;
	@Expose
	@SerializedName("pointsExpireSoon")
     private long pointsExpireSoon;
	@Expose
	@SerializedName("amountExpireSoon")
     private long  amountExpireSoon;
	public String getLoyaltyId() {
		return loyaltyId;
	}
	public void setLoyaltyId(String loyaltyId) {
		this.loyaltyId = loyaltyId;
	}
	public long getBalancePoint() {
		return balancePoint;
	}
	public void setBalancePoint(long balancePoint) {
		this.balancePoint = balancePoint;
	}
	public long getBalanceAmount() {
		return balanceAmount;
	}
	public void setBalanceAmount(long balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
	public long getPointsExpireSoon() {
		return pointsExpireSoon;
	}
	public void setPointsExpireSoon(long pointsExpireSoon) {
		this.pointsExpireSoon = pointsExpireSoon;
	}
	public long getAmountExpireSoon() {
		return amountExpireSoon;
	}
	public void setAmountExpireSoon(long amountExpireSoon) {
		this.amountExpireSoon = amountExpireSoon;
	}
	
	
}
