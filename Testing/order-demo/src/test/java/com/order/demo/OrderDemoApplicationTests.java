package com.order.demo;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.order.demo.services.OrderService;
import com.order.demo.services.PaymentService;

@ExtendWith(MockitoExtension.class)
class OrderDemoApplicationTests {

	@Mock
	private PaymentService paymentService;
	
	@InjectMocks
	private OrderService orderService;
	
	@Test
	void placeOrder_success() {
		when(paymentService.processPayment("Order123")).thenReturn("SUCCESS");
		
		String result = orderService.placeOrder("Order123");
	}
}
