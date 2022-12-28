package com.te.ecommerce.dto;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
	
	private String emailid;
	private String userName;
	private String password;

}
