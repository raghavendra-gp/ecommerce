package com.te.ecommerce.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	@Value("${app.secret}")
	private String secret;

//	Generating token
	public String generateToken(String subject) {
		return Jwts.builder().setSubject(subject).setIssuer("MeHulk").setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(15)))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes()).compact();
	}

//	Read claims
	public Claims getClaims(String token) {
		return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
	}

//	to reas username
	public String getUsername(String token) {
		return getClaims(token).getSubject();
	}

//	to read expiry date
	public Date getExpDate(String token) {
		return getClaims(token).getExpiration();
	}

//	validate exp date
	public boolean isTokenExp(String token) {
		Date expDate = getExpDate(token);
		return expDate.before(new Date(System.currentTimeMillis()));

	}

//	validate user in token and database, expDate
	public boolean validateToken(String token, String username) {
		String tokenUsername = getUsername(token);
		return (username.equals(tokenUsername) && !isTokenExp(token));
	}
}
