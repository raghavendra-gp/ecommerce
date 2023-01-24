package com.te.ecommerce.service;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.te.ecommerce.response.EmailDetails;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmailServiceImpl implements EmailService {

	private final JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String sender;

	@Override
	public String sendEmail(EmailDetails emailDetails) {

		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();

			mailMessage.setFrom(sender);
			mailMessage.setTo(emailDetails.getRecipient());
			mailMessage.setText(emailDetails.getMsgBody());
			mailMessage.setSubject(emailDetails.getSubject());

			javaMailSender.send(mailMessage);
			return "Mail sent sucessfully";

		} catch (MailException e) {
			return "Error while sending email";
		}
	}

	@Override
	public String sendEmailAttachment(EmailDetails emailDetails) {

		MimeMessage message = javaMailSender.createMimeMessage();

		MimeMessageHelper mimeMessageHelper;

		try {

			mimeMessageHelper = new MimeMessageHelper(message);
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(emailDetails.getRecipient());
			mimeMessageHelper.setText(emailDetails.getMsgBody());
			mimeMessageHelper.setSubject(emailDetails.getSubject());

			FileSystemResource resource = new FileSystemResource(new File(emailDetails.getAttachent()));

			mimeMessageHelper.addAttachment(resource.getFilename(), resource);

			javaMailSender.send(message);
			return "Mail sent sucessfully";

		} catch (Exception e) {
			throw new com.te.ecommerce.exceptions.MailException("Not working");
		}

	}

}
