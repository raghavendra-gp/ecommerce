package com.te.ecommerce.exceptions;

@SuppressWarnings("serial")
public class SalesOrderNotFoundException extends RuntimeException {

	public SalesOrderNotFoundException() {
		super();
	}

	public SalesOrderNotFoundException(String message) {
		super("check id and try again");
	}

}
