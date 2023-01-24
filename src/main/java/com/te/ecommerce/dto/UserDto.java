package com.te.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {

	private String userName;
	private String emailid;
	private String password;
	private String roles;
	
	private String firstName;
	private String lastName;
	private Long customerPhone;

}
