package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.service.ProductService;

/*
 * This API returns the list of products available through an HTTP GET request.
 * 
 */
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(value = "/products")
	public ResponseEntity<List<Product>> getProduct() {
		List<Product> products = productService.findAll();

		return new ResponseEntity<>(products, HttpStatus.OK);
	}

}
