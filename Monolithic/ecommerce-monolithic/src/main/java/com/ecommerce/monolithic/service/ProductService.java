package com.ecommerce.monolithic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.monolithic.model.Product;

@Service
public class ProductService {
	private List<Product> products = new ArrayList<>();
	
	public List<Product> getAllProducts(){
		return products;
	}
	
	public Product addProducts(Product product) {
		 products.add(product);
		 return product;
	}
}
