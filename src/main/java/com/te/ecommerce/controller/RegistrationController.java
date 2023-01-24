package com.te.ecommerce.controller;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.te.ecommerce.dto.AuthorityRegister;
import com.te.ecommerce.dto.UserDto;
import com.te.ecommerce.response.AppResponse;
import com.te.ecommerce.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cust")
@RequiredArgsConstructor
public class RegistrationController {

	private final UserService userService;
	
	

	private static final String SUCCESS = "Sucessfully Added";
	private static final String FAIL = "Unsucessfull";
	
	@PostMapping("/registerAuthority")
	public ResponseEntity<AppResponse> registerAuthority(@RequestBody AuthorityRegister authorityRegister) {
		Integer registerAuthority = userService.registerAuthority(authorityRegister);
		if (registerAuthority != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message(SUCCESS)
					.data(Arrays.asList(registerAuthority)).status(200).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(AppResponse.builder().error(true).message(FAIL).status(204).build(),
					HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	

	@PostMapping("/registerUser")
	public ResponseEntity<AppResponse> register(@RequestBody UserDto registration) {
		Integer register = userService.register(registration);
		if (register != null) {
			return new ResponseEntity<>(AppResponse.builder().error(false).message(SUCCESS)
					.data(Arrays.asList(register)).status(200).build(), HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(AppResponse.builder().error(true).message(FAIL).status(204).build(),
					HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/confirm-account/{id}", method = { RequestMethod.GET })
	public ResponseEntity<AppResponse> emailConfirmation(@PathVariable Integer id) {
		String emailConfirmation = userService.emailConfirmation(id);

		return new ResponseEntity<>(AppResponse.builder().error(false).message(SUCCESS)
				.data(Arrays.asList(emailConfirmation)).status(200).build(), HttpStatus.ACCEPTED);
	}

}
