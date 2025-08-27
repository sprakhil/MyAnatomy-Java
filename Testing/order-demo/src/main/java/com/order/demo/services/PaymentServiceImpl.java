package com.order.demo.services;

import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Override
	public String processPayment(String orderId) {
		
		if(orderId == null || orderId.isEmpty()) return "FAIL";
		if(orderId.startsWith("fail")) return "FAIL";
		
		return null;
	}
	
}
