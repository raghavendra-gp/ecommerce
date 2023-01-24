package com.te.ecommerce.service;

import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.te.ecommerce.entity.Roles;
import com.te.ecommerce.entity.User;
import com.te.ecommerce.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> optionalAU = userRepository.findByUserName(username);
		if (optionalAU.isPresent()) {
			User appUser = optionalAU.get();
			Function<Roles, SimpleGrantedAuthority> function = r -> {
				return new SimpleGrantedAuthority(r.getRoleName());
			};
			Set<SimpleGrantedAuthority> authorities = appUser.getRoles().stream().map(function)
					.collect(Collectors.toSet());

			return new org.springframework.security.core.userdetails.User(username, appUser.getPassword(), authorities);
		}
		throw new UsernameNotFoundException("User with username '" + username + "' does not exist!");
	}

	

}
