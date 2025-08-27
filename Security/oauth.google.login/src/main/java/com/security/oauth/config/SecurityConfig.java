package com.security.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth.requestMatchers("/", "/home").permitAll()
				.anyRequest().authenticated()
				).oauth2Login(oauth -> oauth
						.defaultSuccessUrl("/welcome", true));
		
		return http.build();
	}
}
