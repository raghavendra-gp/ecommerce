package com.te.ecommerce.controller;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.te.ecommerce.exceptions.AddressException;
import com.te.ecommerce.exceptions.AddressNotFoundException;
import com.te.ecommerce.exceptions.CartItemException;
import com.te.ecommerce.exceptions.CustomerException;
import com.te.ecommerce.exceptions.MailException;
import com.te.ecommerce.exceptions.ProductException;
import com.te.ecommerce.exceptions.ProductNotFoundException;
import com.te.ecommerce.exceptions.SalesOrderException;
import com.te.ecommerce.exceptions.SalesOrderNotFoundException;
import com.te.ecommerce.exceptions.SortException;
import com.te.ecommerce.response.AppResponse;

@ControllerAdvice
public class GlobalExceptionHander {

	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<AppResponse> exceptionHandler(CustomerException customerException) {

		return new ResponseEntity<>(AppResponse.builder().error(true)
				.data(Arrays.asList(customerException.getMessage())).status(204).build(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MailException.class)
	public ResponseEntity<AppResponse> exceptionHandler(MailException mailException) {

		return new ResponseEntity<>(AppResponse.builder().error(true)
				.data(Arrays.asList(mailException.getMessage())).status(204).build(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AddressException.class)
	public ResponseEntity<AppResponse> exceptionHandler(AddressException addressException) {

		return new ResponseEntity<>(AppResponse.builder().error(true).data(Arrays.asList(addressException.getMessage()))
				.status(204).build(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<AppResponse> exceptionHandler(AddressNotFoundException addressNotFoundException) {

		return new ResponseEntity<>(AppResponse.builder().error(true)
				.data(Arrays.asList(addressNotFoundException.getMessage())).status(204).build(),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<AppResponse> exceptionHandler(ProductNotFoundException productNotFoundException) {

		return new ResponseEntity<>(AppResponse.builder().error(true)
				.data(Arrays.asList(productNotFoundException.getMessage())).status(204).build(),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ProductException.class)
	public ResponseEntity<AppResponse> exceptionHandler(ProductException productException) {

		return new ResponseEntity<>(AppResponse.builder().error(true).data(Arrays.asList(productException.getMessage()))
				.status(204).build(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(SalesOrderException.class)
	public ResponseEntity<AppResponse> exceptionHandler(SalesOrderException salesOrderException) {

		return new ResponseEntity<>(AppResponse.builder().error(true)
				.data(Arrays.asList(salesOrderException.getMessage())).status(204).build(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CartItemException.class)
	public ResponseEntity<AppResponse> exceptionHandler(CartItemException cartItemException) {

		return new ResponseEntity<>(AppResponse.builder().error(true)
				.data(Arrays.asList(cartItemException.getMessage())).status(204).build(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(SalesOrderNotFoundException.class)
	public ResponseEntity<AppResponse> exceptionHandler(SalesOrderNotFoundException salesOrderNotFoundException) {

		return new ResponseEntity<>(AppResponse.builder().error(true)
				.data(Arrays.asList(salesOrderNotFoundException.getMessage())).status(204).build(),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(SortException.class)
	public ResponseEntity<AppResponse> exceptionHandler(SortException sortException) {

		return new ResponseEntity<>(
				AppResponse.builder().error(true).data(Arrays.asList(sortException.getMessage())).status(204).build(),
				HttpStatus.BAD_REQUEST);
	}

}
