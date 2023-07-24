package com.erabia.arbahi.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.apache.logging.log4j.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.erabia.arbahi.bean.CustomerBalanceResponse;
import com.erabia.arbahi.bean.CustomerInfoRequest;
import com.erabia.arbahi.bean.CustomerInfoResponse;
import com.erabia.arbahi.bean.CustomerRedeemRequest;
import com.erabia.arbahi.bean.CustomerRedeemResponse;
import com.erabia.arbahi.bean.CustomerReverseRedemptionRequest;
import com.erabia.arbahi.bean.CustomerTransactionsResponse;
import com.erabia.arbahi.bean.CustomerUpdateInfoResponse;
import com.erabia.arbahi.bean.UpdateCustomerRequest;
import com.erabia.arbahi.exception.ArbahiException;
import com.erabia.arbahi.exception.WebServiceApiUnirestException;
import com.erabia.arbahi.exception.enums.ArbahiExceptionType;
import com.erabia.arbahi.service.ArbahiService;
import com.erabia.arbahi.util.WebServiceApiUnirestUtil;
import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service("arbahiService")
public class DefaultArbahiService implements ArbahiService {
	
	private static final String CONTENT_TYPE = "application/json";
	private static final String BASEURL_IS_NULL="baseURL is null";
	private static final String API_KEY="api key is null";
	private static final String LOYALTY_ID_IS_NULL = "loyaltyId is null";
	private static final String MOBILE_IS_NULL = "mobile number is null";
	private static final String LOYALTY_NAME_IS_NULL = "loyalty name is null";
	private static final String PHONE_IS_NULL = "phone1 is null";
	private static final Gson GSON = (new GsonBuilder().setPrettyPrinting()).create();
	private static final Logger LOG = LoggerFactory.getLogger(DefaultArbahiService.class);
	
	@Override
	public Optional<CustomerInfoResponse> getCustomerInfoByMobile(String baseURL, String apiKey, String mobile)
			throws ArbahiException {
		validationMainParameters(baseURL, apiKey);
		Preconditions.checkArgument(!Strings.isBlank(mobile), MOBILE_IS_NULL);
		final Map<String, String> header = setHeader(apiKey);
		baseURL = new StringBuilder().append(baseURL).append("/GetByMobile/").append(mobile).toString();
		CustomerInfoResponse response =null;
		try
		{
			LOG.info("get Loyalty Customers by mobile number--> sending request");
			response= WebServiceApiUnirestUtil.get(baseURL, header, mobile,CustomerInfoResponse.class);

		}catch (WebServiceApiUnirestException e) {
			throw new ArbahiException(ArbahiExceptionType.BAD_REQUEST, e.getMessage(), e.getRequestData(), e.getResponseData(),e.getHeaders(),e.getBaseURL());
		}

		
		if(response.getSuccess()|| response.getStatusCode() ==200)
		{
			LOG.info("get Loyalty Customers By Id--> success");
			return Optional.ofNullable(response);
		}
		LOG.info("get Loyalty Customers By Id--> bad request");
		throw new ArbahiException(ArbahiExceptionType.BAD_REQUEST, response.getMessage(), GSON.toJson(mobile),  GSON.toJson(response),GSON.toJson(header),baseURL);
	}
	
	@Override
	public Optional<CustomerInfoResponse> getCustomerInfoById(String baseURL, String apiKey, String loyaltyId)
			throws ArbahiException {
		validationMainParameters(baseURL, apiKey);
        Preconditions.checkArgument(!Strings.isBlank(loyaltyId), LOYALTY_ID_IS_NULL);
        final Map<String, String> header = setHeader(apiKey);
        baseURL = new StringBuilder().append(baseURL).append("/").append(loyaltyId).toString();
		CustomerInfoResponse response =null;
		try
		{
			LOG.info("get Loyalty Customers By Id--> sending request");
			response= WebServiceApiUnirestUtil.get(baseURL, header, loyaltyId,CustomerInfoResponse.class);

		}catch (WebServiceApiUnirestException e) {
			LOG.info("get Loyalty Customers By Id--> bad request");
			throw new ArbahiException(ArbahiExceptionType.BAD_REQUEST, e.getMessage(), e.getRequestData(), e.getResponseData(),e.getHeaders(),e.getBaseURL());
		}

		if(response.getSuccess()|| response.getStatusCode() ==200)
		{
			LOG.info("get Loyalty Customers By Id--> success");
			return Optional.ofNullable(response);
		}
		LOG.info("get Loyalty Customers By Id--> bad request");
		throw new ArbahiException(ArbahiExceptionType.BAD_REQUEST, response.getMessage(), GSON.toJson(loyaltyId),  GSON.toJson(response),GSON.toJson(header),baseURL);
	}
	private Map<String, String> setHeader(String apiKey) {
		final Map<String, String> header = new HashMap<>();
		header.put("x-api-key", apiKey);
		header.put("Content-Type",CONTENT_TYPE);
		return header;
	}
	private void validationMainParameters(String baseURL, String apiKey) {
		Preconditions.checkArgument(!Strings.isBlank(baseURL), BASEURL_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(apiKey), API_KEY);
	}
	@Override
	public Optional<CustomerBalanceResponse> getBalance(String baseURL, String apiKey, String loyaltyId)
			throws ArbahiException {
		validationMainParameters(baseURL, apiKey);
        Preconditions.checkArgument(!Strings.isBlank(loyaltyId), LOYALTY_ID_IS_NULL);
        final Map<String, String> header = setHeader(apiKey);
        CustomerBalanceResponse response =null;
        baseURL = new StringBuilder().append(baseURL).append("/").append(loyaltyId).append("/Balance").toString();
        try
		{
			LOG.info("get Balance  by loyaltyId--> sending request");
			response= WebServiceApiUnirestUtil.get(baseURL, header, loyaltyId,CustomerBalanceResponse.class);

		}catch (WebServiceApiUnirestException e) {
			LOG.info("getBalance  by loyaltyId--> bad request");
			throw new ArbahiException(ArbahiExceptionType.BAD_REQUEST, e.getMessage(), e.getRequestData(), e.getResponseData(),e.getHeaders(),e.getBaseURL());
		}

		if(response.getSuccess()|| response.getStatusCode() ==200)
		{
			LOG.info("get Balance  by loyaltyId--> success");
			return Optional.ofNullable(response);
		}
		LOG.info("get Balance  by loyaltyId--> bad request");
		throw new ArbahiException(ArbahiExceptionType.BAD_REQUEST, response.getMessage(), GSON.toJson(loyaltyId),  GSON.toJson(response),GSON.toJson(header),baseURL);
	}
	@Override
	public Optional<CustomerTransactionsResponse> getTransactions(String baseURL, String apiKey, String loyaltyId)
			throws ArbahiException {
		validationMainParameters(baseURL, apiKey);
        Preconditions.checkArgument(!Strings.isBlank(loyaltyId), LOYALTY_ID_IS_NULL);
        final Map<String, String> header = setHeader(apiKey);
        CustomerTransactionsResponse response =null;
        baseURL =new StringBuilder().append(baseURL).append("/").append(loyaltyId).append("/transactions").toString();
        try
		{
			LOG.info("get Transactions  by loyaltyId--> sending request");
			response= WebServiceApiUnirestUtil.get(baseURL, header, loyaltyId,CustomerTransactionsResponse.class);

		}catch (WebServiceApiUnirestException e) {
			LOG.info("get Transactions  by loyaltyId--> bad request");
			throw new ArbahiException(ArbahiExceptionType.BAD_REQUEST, e.getMessage(), e.getRequestData(), e.getResponseData(),e.getHeaders(),e.getBaseURL());
		}

		if(response.getSuccess()|| response.getStatusCode() ==200)
		{
			LOG.info("get Transactions  by loyaltyId--> success");
			return Optional.ofNullable(response);
		}
		LOG.info("get Transactions  by loyaltyId--> bad request");
		throw new ArbahiException(ArbahiExceptionType.BAD_REQUEST, response.getMessage(), GSON.toJson(loyaltyId),  GSON.toJson(response),GSON.toJson(header),baseURL);
	}
	
	@Override
	public Optional<CustomerInfoResponse> createCustomer(String baseURL, String apiKey, CustomerInfoRequest request)
			throws ArbahiException {
		validationMainParameters(baseURL, apiKey);
		Preconditions.checkArgument(!Strings.isBlank(request.getLoyaltyName()), LOYALTY_NAME_IS_NULL);
		Preconditions.checkArgument(!Strings.isBlank(request.getPhone1()), PHONE_IS_NULL);
	final Map<String, String> header = setHeader(apiKey);
		
		CustomerInfoResponse response =null;
		try
		{
			LOG.info("create Customer--> sending request");
			response= WebServiceApiUnirestUtil.post(baseURL, header, GSON.toJson(request),CustomerInfoResponse.class);

		}catch (WebServiceApiUnirestException e) {
			LOG.info("create Customer--> bad request");
			throw new ArbahiException(ArbahiExceptionType.BAD_REQUEST, e.getMessage(), e.getRequestData(), GSON.toJson(e.getResponseData()),e.getHeaders(),e.getBaseURL());
		}
		
		LOG.info("create Customer--> Response");
		return Optional.ofNullable(response);
	}
	

	@Override
	public Optional<CustomerUpdateInfoResponse> updateCustomer(String baseURL, String apiKey, UpdateCustomerRequest request)
			throws ArbahiException {
		validationMainParameters(baseURL, apiKey);
		final Map<String, String> header = setHeader(apiKey);
		baseURL = new StringBuilder().append(baseURL).append("/").append(request.getLoyaltyID()).toString();
		CustomerUpdateInfoResponse response =null;
		try
		{
			LOG.info("update Customer--> sending request");
			response= WebServiceApiUnirestUtil.put(baseURL, header, GSON.toJson(request),CustomerUpdateInfoResponse.class);

		}catch (WebServiceApiUnirestException e) {
			LOG.info("update Customer--> bad request");
			throw new ArbahiException(ArbahiExceptionType.BAD_REQUEST, e.getMessage(), e.getRequestData(), GSON.toJson(e.getResponseData()),e.getHeaders(),e.getBaseURL());
		}

		if(response.getSuccess()|| response.getStatusCode() ==200)
		{
			LOG.info("update Customer--> success");
			return Optional.ofNullable(response);
		}
		LOG.info("update Customer--> bad request");
		throw new ArbahiException(ArbahiExceptionType.BAD_REQUEST, response.getMessage(), GSON.toJson(request),  GSON.toJson(response),GSON.toJson(header),baseURL);
	}
	@Override
	public Optional<CustomerRedeemResponse> redeem(String baseURL, String apiKey, CustomerRedeemRequest request)
			throws ArbahiException {
		validationMainParameters(baseURL, apiKey);
        final Map<String, String> header = setHeader(apiKey);
		if(request.getPointsAmount()<=0)
			throw new ArbahiException(ArbahiExceptionType.POINTS_AMOUNT_IS_ZERO, ArbahiExceptionType.POINTS_AMOUNT_IS_ZERO.getErrorMessage(), GSON.toJson(request), null,GSON.toJson(header),baseURL);
        CustomerRedeemResponse response =null;
        baseURL = new StringBuilder().append(baseURL).append("/Redeem").toString();
        try
		{
			LOG.info("redeem  by loyaltyId--> sending request");
			response= WebServiceApiUnirestUtil.post(baseURL, header, GSON.toJson(request),CustomerRedeemResponse.class);

		}catch (WebServiceApiUnirestException e) {
			throw new ArbahiException(ArbahiExceptionType.BAD_REQUEST, e.getMessage(), e.getRequestData(), e.getResponseData(),e.getHeaders(),e.getBaseURL());
		}

		
		if(response.getSuccess() || response.getStatusCode() ==200 )
		{
			LOG.info("redeem  by loyaltyId--> success");
			return Optional.ofNullable(response);
		}
		LOG.info("redeem  by loyaltyId--> bad request");
		throw new ArbahiException(ArbahiExceptionType.BAD_REQUEST, response.getMessage(), GSON.toJson(request),  GSON.toJson(response),GSON.toJson(header),baseURL);
	}
	@Override
	public Optional<CustomerRedeemResponse> reverseRedemption(String baseURL, String apiKey,
			CustomerReverseRedemptionRequest request) throws ArbahiException {
		validationMainParameters(baseURL, apiKey);
        final Map<String, String> header = setHeader(apiKey);
        if(request.getTransactionId() <= 0)
			throw new ArbahiException(ArbahiExceptionType.TRANSACTION_ID_IS_ZERO, ArbahiExceptionType.TRANSACTION_ID_IS_ZERO.getErrorMessage(), GSON.toJson(request), null,GSON.toJson(header),baseURL);
        CustomerRedeemResponse response =null; 
        baseURL = new StringBuilder().append(baseURL).append("/ReverseRedemption").toString();
        try
		{
			LOG.info("Reverse Redemption  by transactionId--> sending request");
			response= WebServiceApiUnirestUtil.post(baseURL, header, GSON.toJson(request),CustomerRedeemResponse.class);

		}catch (WebServiceApiUnirestException e) {
			LOG.info("Reverse Redemption  by transactionId--> bad request");
			throw new ArbahiException(ArbahiExceptionType.BAD_REQUEST, e.getMessage(), e.getRequestData(), e.getResponseData(),e.getHeaders(),e.getBaseURL());
		}
		
		if(response.getSuccess() || response.getStatusCode() == 200)
		{
			LOG.info("Reverse Redemption  by transactionId--> success");
			return Optional.ofNullable(response);
		}
		LOG.info("Reverse Redemption  by transactionId--> bad request");
		throw new ArbahiException(ArbahiExceptionType.BAD_REQUEST, response.getMessage(), GSON.toJson(request),  GSON.toJson(response),GSON.toJson(header),baseURL);
	}

	
}
