package com.te.ecommerce.service;

import java.util.Optional;

import com.te.ecommerce.entity.User;

public interface UserService {

//	Boolean login(LoginDto loginDto);

	Optional<User> findByUsername(String userName);
	
	Integer register(User registration);
	

}
