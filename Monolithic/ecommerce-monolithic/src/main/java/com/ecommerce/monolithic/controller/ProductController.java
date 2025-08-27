package com.ecommerce.monolithic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.monolithic.model.Product;
import com.ecommerce.monolithic.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public List<Product> getProducts(){
		return productService.getAllProducts();
	}
	
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.addProducts(product);
	}
}
