package com.te.ecommerce.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.te.ecommerce.dto.CustomerRegistration;
import com.te.ecommerce.entity.User;
import com.te.ecommerce.response.AppResponse;
import com.te.ecommerce.service.CustomerService;
import com.te.ecommerce.service.UserService;

@Controller
@RequestMapping("/abc")
public class RegistrationController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private UserService userService;

	@Autowired
	private AppResponse appResponse;
	
	
	
	
	@PostMapping("/registerUser")
	private ResponseEntity<String> register(@RequestBody User registration) {
		Integer register = userService.register(registration);
		return ResponseEntity.ok("SUCESSFULL");
	}

	@PostMapping("/register")
	private ResponseEntity<AppResponse> registerCustomer(@RequestBody CustomerRegistration registerCustomer) {
		CustomerRegistration customerRegistration = customerService.registerCustomer(registerCustomer);
		if (customerRegistration != null) {
			appResponse.setError(false);
			appResponse.setMessage("Sucessfully Added");
			appResponse.setData(Arrays.asList(customerRegistration));
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);

		} else {
			appResponse.setError(true);
			appResponse.setMessage("Unsucessfully Attempt");
			appResponse.setStatus(200);
			return new ResponseEntity<AppResponse>(appResponse, HttpStatus.ACCEPTED);
		}

	}

}
