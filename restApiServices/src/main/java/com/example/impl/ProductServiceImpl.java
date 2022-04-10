
package com.example.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.exception.ProductDetailsNotFountException;
import com.example.model.Product;
import com.example.service.ProductService;

/*
 * This service provides the implementation for various functionalities related to product.
 */
@Service
public class ProductServiceImpl implements ProductService {

	// Fetch all products.
	@Override
	public List<Product> findAll() {
		List<Product> products = null;
		try {
			// Dummy product data.
			products = getProductDetails();
			if (products == null) {

				throw new ProductDetailsNotFountException(
						"Excetion occured while getting product details in ProductServiceImpl");
			}

		} catch (Exception e) {
			//log exception
			System.out
					.println("Excetion occured while getting product details in ProductServiceImpl " + e.getMessage());
		}
		return products;
	}

	public List<Product> getProductDetails() {
		try {
			List<Product> products = new ArrayList<Product>();
			products.add(new Product(100, "Mobile", "A0001", 9000.00, 6));
			products.add(new Product(101, null, "A0002", 60000.00, 3));
			products.add(new Product(102, "Washing Machine", "A0003", 9000.00, 7));
			products.add(new Product(103, "Laptop", "A0004", 24000.00, 1));
			products.add(new Product(104, "Air Conditioner", "A0005", 30000.00, 5));
			products.add(new Product(105, "Refrigerator ", "A0006", 10000.00, 4));
			return products;
		}catch(Exception e) {
			//log exception
		}
		return null;
		
	}

}
