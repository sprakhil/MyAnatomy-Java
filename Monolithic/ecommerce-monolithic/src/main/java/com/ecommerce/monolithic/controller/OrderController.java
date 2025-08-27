package com.ecommerce.monolithic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.monolithic.model.Order;
import com.ecommerce.monolithic.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired 
	private OrderService orderService;
	
	@GetMapping
	public List<Order> getAllOrder(){
		return orderService.getAllOrder();
	}
	
	@PostMapping
	public Order addOrder(@RequestBody Order order) {
		return orderService.addOrder(order);
	}
}
