package com.te.ecommerce.exceptions;

@SuppressWarnings("serial")
public class ProductException extends RuntimeException {

	public ProductException() {
		super();
	}

	public ProductException(String message) {
		super(message);
	}

}
