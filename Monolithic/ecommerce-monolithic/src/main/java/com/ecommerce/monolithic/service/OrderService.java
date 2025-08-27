package com.ecommerce.monolithic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.monolithic.model.Order;

@Service
public class OrderService {
	
	private List<Order> orders = new ArrayList<>();
	
	public List<Order> getAllOrder(){
		return orders;
	}
	
	public Order addOrder(Order order) {
		orders.add(order);
		return order;
	}
}
