package com.te.ecommerce.exceptions;

@SuppressWarnings("serial")
public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException() {
		super();
	}

	public ProductNotFoundException(String message) {
		super("Product Not Found");
	}

}
