package com.ecommerce.monolithic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.monolithic.model.User;
import com.ecommerce.monolithic.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> getUser(){
		return userService.getAllUser();
	}
	
	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.addUser(user);
	}
}
