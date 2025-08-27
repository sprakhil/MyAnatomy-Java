package com.security.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.jwt.model.AuthenticationRequest;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AuthController {
	
	@PostMapping("/login")
	public String login(@RequestBody AuthenticationRequest authRequest){
		if("user".equals(authRequest.getUsername()) && "password".equals(authRequest.getPassword())) {
			return "JWT_TOKEN-12345";
		}
		return "Invalid Username and Password";
	}
}