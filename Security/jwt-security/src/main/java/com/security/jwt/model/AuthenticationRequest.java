package com.security.jwt.model;

public class AuthenticationRequest {
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername1(String username1) {
		this.username = username1;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
