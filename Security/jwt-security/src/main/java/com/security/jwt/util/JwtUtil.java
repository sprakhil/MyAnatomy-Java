package com.security.jwt.util;

import java.util.Date;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
	private static final String SECRET = "mysecret";
	
	//Generate JWT
	public static String generateToken(String username){
		
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 1000*60*5))
				.signWith(SignatureAlgorithm.HS256,SECRET)
				.compact();
	}
	
	//Validate JWT
	public static String validToken(String token) {
		return Jwts.parser()
				.setSigningKey(SECRET)
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
	}
}
