package com.erabia.arbahi.service;

import java.util.Optional;

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

public interface ArbahiService {
	
	public Optional<CustomerInfoResponse> getCustomerInfoByMobile(final String baseURL,final String apiKey, final String mobile) throws ArbahiException;
	public Optional<CustomerInfoResponse> getCustomerInfoById(final String baseURL,final String apiKey, final String loyaltyId) throws ArbahiException;
	public Optional<CustomerBalanceResponse> getBalance(final String baseURL,final String apiKey, final String loyaltyId) throws ArbahiException;
	public Optional<CustomerTransactionsResponse> getTransactions(final String baseURL,final String apiKey, final String loyaltyId) throws ArbahiException;
	public Optional<CustomerInfoResponse> createCustomer(final String baseURL,final String apiKey,CustomerInfoRequest request) throws ArbahiException;
	public Optional<CustomerUpdateInfoResponse> updateCustomer(final String baseURL,final String apiKey, UpdateCustomerRequest request) throws ArbahiException;
	public Optional<CustomerRedeemResponse> redeem(final String baseURL,final String apiKey, CustomerRedeemRequest request) throws ArbahiException;
	public Optional<CustomerRedeemResponse> reverseRedemption(final String baseURL,final String apiKey, CustomerReverseRedemptionRequest request) throws ArbahiException;
}
