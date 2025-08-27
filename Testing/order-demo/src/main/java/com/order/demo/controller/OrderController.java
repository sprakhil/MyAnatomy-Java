package com.order.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.demo.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	
	public ResponseEntity<String> placeOrder(@PathVariable String ID){
		String result = orderService.placeOrder(ID);
		
		return ResponseEntity.ok(result);
	}
}
