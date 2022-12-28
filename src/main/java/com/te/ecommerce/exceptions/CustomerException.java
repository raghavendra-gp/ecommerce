package com.te.ecommerce.exceptions;

@SuppressWarnings("serial")
public class CustomerException extends RuntimeException {

	public CustomerException() {
		super();
	}

	public CustomerException(String message) {
		super(message);
	}

}
