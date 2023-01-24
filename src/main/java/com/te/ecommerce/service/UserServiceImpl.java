package com.te.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.te.ecommerce.dto.AuthorityRegister;
import com.te.ecommerce.dto.UserDto;
import com.te.ecommerce.entity.Authority;
import com.te.ecommerce.entity.Customer;
import com.te.ecommerce.entity.Roles;
import com.te.ecommerce.entity.User;
import com.te.ecommerce.exceptions.CustomerException;
import com.te.ecommerce.repository.AuthorityRepository;
import com.te.ecommerce.repository.CustomerRepository;
import com.te.ecommerce.repository.RoleRepository;
import com.te.ecommerce.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	private final CustomerRepository customerRepository;

	private final BCryptPasswordEncoder passwordEncoder;

	private final RoleRepository roleRepository;

	private final JavaMailSender javaMailSender;
	
	private final AuthorityRepository authorityRepository;

	@Override
	public Integer register(UserDto registration) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(registration, customer);

		User appUser = new User();
		appUser.setUserName(registration.getUserName());
		appUser.setPassword(passwordEncoder.encode(registration.getPassword()));
		appUser.setRoles(Lists.newArrayList());
		appUser.setEmailid(registration.getEmailid());
		User save = userRepository.save(appUser);
		List<User> appUsers = new ArrayList<>();
		appUsers.add(save);

		Roles roles = new Roles();
		roles.setRoleName(registration.getRoles());
		roles.setAppUsers(null);
		roles.setAppUsers(appUsers);
		roleRepository.save(roles);

		return customerRepository.save(customer).getId();
	}
//
//	@Override
//	public Optional<User> findByUsername(String userName) {
//		return userRepository.findByUserName(userName);
//	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Optional<User> byUsername = findByUsername(username);
//		if (byUsername.isEmpty()) {
//			throw new UsernameNotFoundException("User not found");
//		}
//		User user = byUsername.get();
//		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), user.getRoles()
//				.stream().map((roles) -> new SimpleGrantedAuthority(roles)).collect(Collectors.toList()));
//	}

	@Override
	public String emailConfirmation(Integer id) {
		User user = userRepository.findById(id).orElseThrow(CustomerException::new);
		user.setEnabled(true);
		userRepository.save(user);

		return "Confirmation Sucessfull";

	}

	@Override
	public Integer registerAuthority(AuthorityRegister authorityRegister) {
		Authority authority = new Authority();
		BeanUtils.copyProperties(authorityRegister, authority);
		
		User appUser = new User();
		appUser.setUserName(authorityRegister.getUserName());
		appUser.setPassword(passwordEncoder.encode(authorityRegister.getPassword()));
		appUser.setRoles(Lists.newArrayList());
		appUser.setEmailid(authorityRegister.getEmailid());
		User save = userRepository.save(appUser);
		List<User> appUsers = new ArrayList<>();
		appUsers.add(save);

		Roles roles = new Roles();
		roles.setRoleName(authorityRegister.getRoles());
		roles.setAppUsers(null);
		roles.setAppUsers(appUsers);
		roleRepository.save(roles);
		
		return authorityRepository.save(authority).getId();
	}

//	@Override
//	public Optional<User> findByUsername(String userName) {
//		// TODO Auto-generated method stub
//		return Optional.empty();
//	}

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
