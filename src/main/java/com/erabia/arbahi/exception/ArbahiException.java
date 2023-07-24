package com.erabia.arbahi.exception;


import com.erabia.arbahi.exception.enums.ArbahiExceptionType;

/**
 * 
 *
 */
public class ArbahiException extends Exception {
	private static final long serialVersionUID = -2727878348941788892L;
	private final ArbahiExceptionType type;
	private final String requestData;
	private final String responseData;
	private final String headers;
	private final String baseURL;



	public ArbahiException(final ArbahiExceptionType type,  final String message,final String requestData, final String responseData,
			final String headers, final String baseURL ){
		super(message);
		this.type = type;
		this.requestData = requestData;
		this.responseData = responseData;
		this.headers = headers;
		this.baseURL = baseURL;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ArbahiExceptionType getType() {
		return type;
	}

	public String getRequestData() {
		return requestData;
	}

	public String getResponseData() {
		return responseData;

	}

	public final String getHeaders() {
		return headers;
	}

	public final String getBaseURL() {
		return baseURL;
	}
	
	
}

