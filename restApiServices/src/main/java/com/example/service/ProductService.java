package com.example.service;

import java.util.List;

import com.example.model.Product;

/*
 * The interface provides an abstraction for the implementation of fetching the products.
 */
public interface ProductService {
	
	List<Product> findAll();  
}
