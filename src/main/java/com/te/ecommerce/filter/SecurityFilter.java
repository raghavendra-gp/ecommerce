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

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class SecurityFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil util;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		if (request.getServletPath().equalsIgnoreCase(null)) {

			filterChain.doFilter(request, response);

		} else {
			String bearerToken = request.getHeader("Authorization");
			if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
				String token = bearerToken.substring(7);

				String usernameFromToken = util.getUsername(token);
				UserDetails userFromDb = userDetailsService.loadUserByUsername(usernameFromToken);
				if (usernameFromToken != null && userFromDb.getUsername() != null
						&& SecurityContextHolder.getContext().getAuthentication() == null) {
					if (util.validateToken(token, userFromDb.getUsername())) {

						UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
								userFromDb.getUsername(), userFromDb.getPassword(), userFromDb.getAuthorities());

						authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

						SecurityContextHolder.getContext().setAuthentication(authenticationToken);
					}
				}
			}
			filterChain.doFilter(request, response);
		}

	}

}
