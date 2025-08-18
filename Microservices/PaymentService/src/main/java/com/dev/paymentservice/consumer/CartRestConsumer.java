package com.dev.paymentservice.consumer;

import java.util.List;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

@Component
public class CartRestConsumer {
	private DiscoveryClient discoveryClient;
	
	public String getCartData(){
		List<ServiceInstance> instance = discoveryClient.getInstances("CART-SERVICE");
		
		if(instance == null || instance.isEmpty()) {
			return "CAR-SERVICE not available";
		}
		return "";
	}
	
}
