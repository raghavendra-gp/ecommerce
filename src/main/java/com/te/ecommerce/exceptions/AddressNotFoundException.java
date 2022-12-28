package com.te.ecommerce.exceptions;

@SuppressWarnings("serial")
public class AddressNotFoundException extends RuntimeException{

	public AddressNotFoundException() {
		super();
	}

	public AddressNotFoundException(String message) {
		super("Not Found");
	}

}
