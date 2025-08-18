package com.dev.cartservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
	
	@GetMapping("/cart/getData")
	public String getCartData() {
		return "Returning data from CART_SERVICE";
	}
}
