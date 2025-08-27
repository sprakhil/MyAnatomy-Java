package com.ecommerce.monolithic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.monolithic.model.User;

@Service
public class UserService {
	private List<User> users = new ArrayList<>();
	
	public List<User> getAllUser(){
		return users;
	}
	
	public User addUser(User user) {
		users.add(user);
		return user;
	}
	
}
