package com.te.ecommerce.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.te.ecommerce.util.JwtUtil;

@Component
public class SecurityFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtUtil util;
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		
//		Readable token from authorization header
		String token = request.getHeader("Authorization");
		if (token!=null) {
			//validation
			String username = util.getUsername(token);
//			username should not be empty and context holder should be empty
			if (username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
				UserDetails loadUser = userDetailsService.loadUserByUsername(username);
				
				boolean isValidateToken = util.validateToken(token, loadUser.getUsername());
				
				if (isValidateToken) {
					UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, loadUser.getPassword());
					
					authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					
//					final object stored in Securtiy context with User Details(usrname, pwd)
					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
					
				}
			}
		}  
		filterChain.doFilter(request, response);
	}

}
