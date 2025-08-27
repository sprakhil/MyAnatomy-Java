package com.dev.paymentservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/payment")
	public String pay() {
		return "Payment Successful!(from port " + port + " )";
	}
}
