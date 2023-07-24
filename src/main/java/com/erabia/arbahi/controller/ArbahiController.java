package com.erabia.arbahi.controller;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.erabia.arbahi.bean.CustomerBalanceResponse;
import com.erabia.arbahi.bean.CustomerInfoRequest;
import com.erabia.arbahi.bean.CustomerInfoResponse;
import com.erabia.arbahi.bean.CustomerRedeemRequest;
import com.erabia.arbahi.bean.CustomerRedeemResponse;
import com.erabia.arbahi.bean.CustomerReverseRedemptionRequest;
import com.erabia.arbahi.bean.CustomerTransactionsResponse;
import com.erabia.arbahi.bean.CustomerUpdateInfoResponse;
import com.erabia.arbahi.bean.UpdateCustomerRequest;
import com.erabia.arbahi.dto.error.ErrorDTO;
import com.erabia.arbahi.dto.error.ErrorListDTO;
import com.erabia.arbahi.exception.ArbahiException;
import com.erabia.arbahi.service.ArbahiService;

@RestController
@RequestMapping(path = "/LoyaltyCustomers")
public class ArbahiController {
	
	private static final String BASE_URL = "http://staging-oms.al-dawaa.com/LoyaltyCustomers";
	private static final String API_KEY="98a6b9c00e944608be91db86a2e70968";
        @Autowired
		private ArbahiService arbahiService;


		@GetMapping(path = "/GetByMobile/{mobile}")
		public CustomerInfoResponse getCustomerInfoByMObile(
				@RequestParam(defaultValue = BASE_URL, required = true) String baseUrl,
				@RequestParam(defaultValue = API_KEY, required = true) String apiKey,
				@PathVariable(required = true) String mobile) throws ArbahiException  {
			Optional<CustomerInfoResponse> loyaltyCustomers = arbahiService.getCustomerInfoByMobile(baseUrl,API_KEY, mobile);
			return loyaltyCustomers.isPresent() ? loyaltyCustomers.get() : null;
		}
		@GetMapping(path = "/{loyaltyId}")
		public CustomerInfoResponse getCustomerInfoById(
				@RequestParam(defaultValue = BASE_URL, required = true) String baseUrl,
				@RequestParam(defaultValue = API_KEY, required = true) String apiKey,
				@PathVariable(required = true) String loyaltyId) throws ArbahiException  {
			Optional<CustomerInfoResponse> loyaltyCustomers = arbahiService.getCustomerInfoById(baseUrl,apiKey, loyaltyId);
			return loyaltyCustomers.isPresent() ? loyaltyCustomers.get() : null;
		}
		@GetMapping(path = "/{loyaltyId}/Balance")
		public CustomerBalanceResponse getBalance(
				@RequestParam(defaultValue = BASE_URL, required = true) String baseUrl,
				@RequestParam(defaultValue = API_KEY, required = true) String apiKey,
				@PathVariable(required = true) String loyaltyId) throws ArbahiException  {
			Optional<CustomerBalanceResponse> loyaltyCustomers = arbahiService.getBalance(baseUrl,apiKey, loyaltyId);
			return loyaltyCustomers.isPresent() ? loyaltyCustomers.get() : null;
		}
		@GetMapping(path = "/{loyaltyId}/transactions")
		public CustomerTransactionsResponse getTransactions(
				@RequestParam(defaultValue = BASE_URL, required = true) String baseUrl,
				@RequestParam(defaultValue = API_KEY, required = true) String apiKey,
				@PathVariable(required = true) String loyaltyId) throws ArbahiException  {
			Optional<CustomerTransactionsResponse> loyaltyCustomers = arbahiService.getTransactions(baseUrl,apiKey, loyaltyId);
			return loyaltyCustomers.isPresent() ? loyaltyCustomers.get() : null;
		}
		@PostMapping
		public CustomerInfoResponse createCustomer(
				@RequestParam(defaultValue = BASE_URL, required = true) String baseUrl,
				@RequestParam(defaultValue = API_KEY, required = true) String apiKey,
				@RequestBody CustomerInfoRequest requestBody
				) throws ArbahiException  {
					CustomerInfoRequest infoRequest = new CustomerInfoRequest(requestBody.getLoyaltyName(),
							requestBody.getFirstName(), requestBody.getLastName(), requestBody.getPhone1(),
							requestBody.getEmail(), requestBody.getGender(), requestBody.getCity(),
							requestBody.getNationality());
					Optional<CustomerInfoResponse> loyaltyCustomers = arbahiService.createCustomer(baseUrl, apiKey,
							infoRequest);
					return loyaltyCustomers.isPresent() ? loyaltyCustomers.get() : null;
		}
		@PutMapping(path = "/{loyaltyId}")
		public CustomerUpdateInfoResponse updateCustomer(
				@RequestParam(defaultValue = BASE_URL, required = true) String baseUrl,
				@RequestParam(defaultValue = API_KEY, required = true) String apiKey,
				@RequestBody UpdateCustomerRequest requestBody) throws ArbahiException  {
			UpdateCustomerRequest infoRequest = new UpdateCustomerRequest(requestBody.getLoyaltyID(),
					requestBody.getLoyaltyName(), requestBody.getFirstName(), requestBody.getLastName(),
					requestBody.getPhone1(), requestBody.getEmail(), requestBody.getGender(), requestBody.getCity(),
					requestBody.getNationality());
			Optional<CustomerUpdateInfoResponse> loyaltyCustomers = arbahiService.updateCustomer(baseUrl,apiKey, infoRequest);
			return loyaltyCustomers.isPresent() ? loyaltyCustomers.get() : null;
		}
		
		@PostMapping(path = "/Redeem")
		public CustomerRedeemResponse redeem(@RequestParam(defaultValue = BASE_URL, required = true) String baseUrl,
				@RequestParam(defaultValue = API_KEY, required = true) String apiKey,
				@RequestBody CustomerRedeemRequest requestBody
				) throws ArbahiException  {
					CustomerRedeemRequest infoRequest = new CustomerRedeemRequest(requestBody.getLoyaltyId(),
							requestBody.getPointsAmount(), requestBody.getReferenceNumber(),
							requestBody.getOrderNumber());
			Optional<CustomerRedeemResponse> loyaltyCustomers = arbahiService.redeem(BASE_URL,API_KEY, infoRequest);
			return loyaltyCustomers.isPresent() ? loyaltyCustomers.get() : null;
		}
		@PostMapping(path = "/ReverseRedemption")
		public CustomerRedeemResponse reverseRedemption(@RequestParam(defaultValue = BASE_URL, required = true) String baseUrl,
				@RequestParam(defaultValue = API_KEY, required = true) String apiKey,
				@RequestBody CustomerReverseRedemptionRequest requestBody) throws ArbahiException  {
			CustomerReverseRedemptionRequest infoRequest = new CustomerReverseRedemptionRequest(
					requestBody.getTransactionId(), requestBody.getReferenceNumber(), requestBody.getReverseAmount());
			Optional<CustomerRedeemResponse> loyaltyCustomers = arbahiService.reverseRedemption(BASE_URL,API_KEY, infoRequest);
			return loyaltyCustomers.isPresent() ? loyaltyCustomers.get() : null;
		}
		@ResponseStatus(value = HttpStatus.BAD_REQUEST)
		@ResponseBody
		@ExceptionHandler({ ArbahiException.class })
		public ErrorListDTO handleArbahiException(final ArbahiException ex){
			ErrorListDTO errorListDTO=new ErrorListDTO();
			ErrorDTO errorDTO=new ErrorDTO();
			
			errorDTO.setErrorCode(ex.getType().getErrorCode());
			errorDTO.setExceptionMessage(ex.getMessage());
			errorDTO.setReason(ex.getType().getErrorMessage());
			errorDTO.setType(ex.getType().toString());
			errorListDTO.setErrors(Arrays.asList(errorDTO));
			
			return errorListDTO;
		}
		
		@ResponseStatus(value = HttpStatus.BAD_REQUEST)
		@ResponseBody
		@ExceptionHandler({ IllegalArgumentException.class })
		public ErrorListDTO handleIllegalArgumentException(final IllegalArgumentException ex){
			ErrorListDTO errorListDTO=new ErrorListDTO();
			ErrorDTO errorDTO=new ErrorDTO();
			
			errorDTO.setErrorCode(HttpStatus.BAD_REQUEST.toString());
			errorDTO.setExceptionMessage(ex.getMessage());
			errorDTO.setReason(ex.getMessage());
			errorDTO.setType("IllegalArgumentException");
			errorListDTO.setErrors(Arrays.asList(errorDTO));
			
			return errorListDTO;
		}
}
