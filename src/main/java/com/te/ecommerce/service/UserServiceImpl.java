package com.te.ecommerce.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.te.ecommerce.entity.User;
import com.te.ecommerce.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public Integer register(User registration) {
		registration.setPassword(passwordEncoder.encode(registration.getPassword()));
		Integer id = userRepository.save(registration).getId();
		return id;

	}

	@Override
	public Optional<User> findByUsername(String userName) {
		Optional<User> byUsername = userRepository.findByUserName(userName);
		return byUsername;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> byUsername = findByUsername(username);
		if (byUsername.isEmpty()) {
			throw new UsernameNotFoundException("User not found");
		}
		User user = byUsername.get();
		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), user.getRoles()
				.stream().map((roles) -> new SimpleGrantedAuthority(roles)).collect(Collectors.toList()));
	}

//	@Override
//	public Boolean login(LoginDto loginDto) {
//		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//		String userLookupField;
//
//		switch (loginDto.getUserName()) {
//		    case null:
//		        userLookupField = loginDto.getEmail();
//		        break;
//		    default:
//		        userLookupField = loginDto.getUserName();
//		        break;
//		}

//		String userLookupField = switch (loginDto.getUserName()) {
//	    case null -> loginDto.getEmail();
//	    default -> username;
//	};

//		switch (loginDto.getUserName()) {
//		case null:
//			User user = new User();
//			BeanUtils.copyProperties(loginDto, user);
//			Optional<User> emailId = userRepository.findByEmailId(user.getEmailid());
//			
//			break;
//
//		default:
//			break;
//		}

//		if (loginDto.getUserName() != null) {
//			User user = new User();
//			BeanUtils.copyProperties(loginDto, user);
//			Optional<User> userName = userRepository.findByUserName(user.getUserName());
//			Boolean matched = userName.stream().anyMatch((i) -> i.getUserName().equals(user.getUserName())
//					&& passwordEncoder.matches(user.getPassword(), i.getPassword()));
//			if (matched) {
//				return true;
//			} else {
//				return false;
//			}
//		} else {
//			User user = new User();
//			BeanUtils.copyProperties(loginDto, user);
//			Optional<User> emailId = userRepository.findByEmailid(user.getEmailid());
//			Boolean match = emailId.stream().anyMatch((i) -> i.getEmailid().equals(user.getEmailid())
//					&& passwordEncoder.matches(user.getPassword(), i.getPassword()));
//
//			if (match) {
//				return true;
//			} else {
//				return false;
//			}
//		}
//return true;
//	}

}
