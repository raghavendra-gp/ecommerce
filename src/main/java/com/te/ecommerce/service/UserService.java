package com.te.ecommerce.service;

import com.te.ecommerce.dto.AuthorityRegister;
import com.te.ecommerce.dto.UserDto;

public interface UserService {

//	Boolean login(LoginDto loginDto);

//	Optional<User> findByUsername(String userName);
	
	Integer register(UserDto registration);

	String emailConfirmation(Integer id);

	Integer registerAuthority(AuthorityRegister authorityRegister);
	

}
