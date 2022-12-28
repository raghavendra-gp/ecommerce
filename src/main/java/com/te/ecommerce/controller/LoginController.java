package com.te.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.te.ecommerce.dto.LoginDto;
import com.te.ecommerce.dto.UserRequest;
import com.te.ecommerce.response.AppResponse;
import com.te.ecommerce.service.UserService;
import com.te.ecommerce.util.JwtUtil;

@Controller
@RequestMapping("/user")
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private AppResponse appResponse;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/login")
	private ResponseEntity<String> login(@RequestBody UserRequest userRequest) {

		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userRequest.getUserName(), userRequest.getPassword()));
		String token = jwtUtil.generateToken(userRequest.getUserName());

		return ResponseEntity.ok("sucess" + token);

	}
	
	@GetMapping("/well")
	private ResponseEntity<String> welcome() {
		return ResponseEntity.ok("goodd woork");
	}

}
