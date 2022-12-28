package com.te.ecommerce.exceptions;

@SuppressWarnings("serial")
public class SalesOrderException extends RuntimeException {

	public SalesOrderException() {
		super();
	}

	public SalesOrderException(String message) {
		super(message);
	}

}
