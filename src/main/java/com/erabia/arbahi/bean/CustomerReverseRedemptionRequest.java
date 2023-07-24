package com.erabia.arbahi.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerReverseRedemptionRequest {
	@Expose
	@SerializedName("transactionId")
	private long transactionId;
	@Expose
	@SerializedName("referenceNumber")
	private String referenceNumber;
	@Expose
	@SerializedName("reverseAmount")
	private long reverseAmount;
	
	
	public CustomerReverseRedemptionRequest(long transactionId, String referenceNumber, long reverseAmount) {
		super();
		this.transactionId = transactionId;
		this.referenceNumber = referenceNumber;
		this.reverseAmount = reverseAmount;
	}
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public long getReverseAmount() {
		return reverseAmount;
	}
	public void setReverseAmount(long reverseAmount) {
		this.reverseAmount = reverseAmount;
	}

}
