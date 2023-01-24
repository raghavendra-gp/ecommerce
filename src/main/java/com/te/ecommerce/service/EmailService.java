package com.te.ecommerce.service;

import com.te.ecommerce.response.EmailDetails;

public interface EmailService {

	String sendEmail(EmailDetails emailDetails);

	String sendEmailAttachment(EmailDetails emailDetails);

}
