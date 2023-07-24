package com.erabia.arbahi.exception.enums;

public enum ArbahiExceptionType {


	BAD_REQUEST("bad-request","bad request"),
	CUSTOMER_IS_BLOCKED("LOY-00001","Customer Is Blocked"),
	ACTIVITY_ALREADY_POSTED("LOY-00010","Activity Already Posted"),
	ACTIVITY_DOES_NOT_EXISTS("LOY-00332","Activity does not exists"),
	ACTIVITY_IS_NOT_REDEEM("LOY-00423","Activity is not Redeem"),
	NOT_ENOUGH_BALANCE_FOR_REDEMPTION("LOY-00099","Not enough balance for redemption"),
	ERROR_WHILE_REVERSING("LOY-00130","Error while reversing"),
	REVERSE_REDEMPTION_EXCEED_ORIGINAL_ACTIVITY("LOY-00133","Reverse redemption exceed original activity"),
	VALIDATION_ERROR_WHILE_CREATING_CUSTOMER("LOY-00999","Validation error while creating customer"),
	POINTS_AMOUNT_IS_ZERO("POINTS AMOUNT IS ZERO","Points amount is zero"),
	TRANSACTION_ID_IS_ZERO("TRANSACTION ID IS ZERO","Transaction id is zero");
	private String errorCode;
	private String errorMessage;

	private ArbahiExceptionType(String errorCode, String message) {
		this.errorCode = errorCode;
		this.errorMessage = message;
	}

	private ArbahiExceptionType() {
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
