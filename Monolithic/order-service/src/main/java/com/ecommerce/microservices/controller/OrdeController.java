package com.ecommerce.microservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
//@RequestMapping("/order")
public class OrdeController {
	public final RestTemplate restTemplate;

	public OrdeController(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}
	
	@GetMapping("/order")
	
	public String placeOrder() {
//		Use Service name - Loadbalance + Eureka resolve this to an instance
		String response = restTemplate.getForObject("http://payment-service/payment", String.class);
		
		return "Order Placed -> "+response; 
	}
	
	public String paymentFallback(Throwable t){
		return "Payment Service is DOWN! (" +t.getClass().getSimpleName()+" )";
	}
}
