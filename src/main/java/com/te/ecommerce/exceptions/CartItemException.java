package com.te.ecommerce.exceptions;

@SuppressWarnings("serial")
public class CartItemException extends RuntimeException {

	public CartItemException() {
		super();
	}

	public CartItemException(String message) {
		super(message);
	}

}
