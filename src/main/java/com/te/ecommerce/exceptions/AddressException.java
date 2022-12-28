package com.te.ecommerce.exceptions;

@SuppressWarnings("serial")
public class AddressException extends RuntimeException {

	public AddressException() {
		super();
	}

	public AddressException(String message) {
		super(message);
	}

}
