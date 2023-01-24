package com.te.ecommerce.exceptions;

@SuppressWarnings("serial")
public class MailException extends RuntimeException {

	public MailException() {
		super();
	}

	public MailException(String message) {
		super("Couldnt send the email");
	}

}
