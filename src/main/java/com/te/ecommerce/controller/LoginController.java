package com.te.ecommerce.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.ecommerce.dto.UserRequest;
import com.te.ecommerce.response.EmailDetails;
import com.te.ecommerce.service.EmailService;
import com.te.ecommerce.util.JwtUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class LoginController {

	private final JwtUtil jwtUtil;

	private final EmailService emailService;

	private final AuthenticationManager authenticationManager;

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UserRequest userRequest) {

		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userRequest.getUserName(), userRequest.getPassword()));
		String token = jwtUtil.generateToken(userRequest.getUserName());

		return ResponseEntity.ok("sucess   " + token);

	}

	@GetMapping("/well")
	public ResponseEntity<String> welcome() {
		return ResponseEntity.ok("goodd woork");
	}

	@PostMapping("/sendEmail")
	public String sendEmail(@RequestBody EmailDetails emailDetails) {
		return emailService.sendEmail(emailDetails);
	}
	
	

	@PostMapping("/sendEmailAttachment")
	public String sendEmailAttachment(@RequestBody EmailDetails emailDetails) {
		return emailService.sendEmailAttachment(emailDetails);

	}
}
