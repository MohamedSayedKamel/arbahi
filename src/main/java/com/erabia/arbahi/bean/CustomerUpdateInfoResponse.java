package com.erabia.arbahi.bean;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerUpdateInfoResponse {
	
	@Expose
	@SerializedName("data")
	private boolean data;
	@Expose
	@SerializedName("statusCode")
	private long statusCode;
	@Expose
	@SerializedName("success")
	private boolean success;
	@Expose
	@SerializedName("message")
	private String message;
	@Expose
	@SerializedName("errors")
	private List<ErrorBean> errors;
	
	public boolean getData() {
		return data;
	}
	public void setData(boolean data) {
		this.data = data;
	}
	public long getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(long statusCode) {
		this.statusCode = statusCode;
	}
	public boolean getSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<ErrorBean> getErrors() {
		return errors;
	}
	public void setErrors(List<ErrorBean> errors) {
		this.errors = errors;
	}
	
}
