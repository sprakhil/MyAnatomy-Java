package com.dev.cartservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class CartController {
	
	private final RestTemplate restTemplate;
	
	public CartController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@GetMapping("/order")
	@CircuitBreaker(name = "paymentService", fallbackMethod = "paymentFallback")
	public String placeOrder() {
		String response = restTemplate.getForObject("http://PAYMENT-SERVICE/payment", String.class);
		return "ORDER PLACED -> "+ response;
	}
	
	public String paymentFallback(Throwable t){
		return "Payment delayed! ("+t.getClass().getSimpleName()+")";
	}
}
