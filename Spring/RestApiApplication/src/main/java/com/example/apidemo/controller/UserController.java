package com.example.apidemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apidemo.model.User;

@RestController
@RequestMapping("/")
public class UserController {
	@GetMapping("/hello")
	    public String sayHello() {
	        return "Hello from REST API!";
	    }
	
	@GetMapping("/user")
	    public User getUser() {
	        return new User(1, "Anand Pawar");
	    }
}
