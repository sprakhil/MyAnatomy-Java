package com.dev.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "Welcome to the Public Home Page";
	}
	
	@GetMapping("/user")
	public String userPage() {
		return "Welcome to User Page";
	}
	
	@GetMapping("/admin")
	public String adminPage() {
		return "Welcome to Admin Page";
	}
}
