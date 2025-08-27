package com.order.demo.services;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
	private final PaymentService paymentService;

	public OrderService(PaymentService paymentService) {
		super();
		this.paymentService = paymentService;
	}
	
	public String placeOrder(String orderId) {
		
		String paymentResult = paymentService.processPayment(orderId);
		
		if("SUCCESS".equals(paymentResult)) return "Order placed successfully!";
		
		return "Payment failed!";
		
	}
}
