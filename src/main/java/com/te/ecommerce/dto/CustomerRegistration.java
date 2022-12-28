package com.te.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRegistration{
	
	private String userName;
	private String emailid;
	private String password;
	private String firstName;
	private String lastName;
	private Long customerPhone;
//	private boolean enabled;
	private String roles;

}
