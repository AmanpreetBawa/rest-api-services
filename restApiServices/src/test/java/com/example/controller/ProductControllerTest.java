package com.example.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.model.Product;
import com.example.service.ProductService;

@WebMvcTest
public class ProductControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productService;

	@Test
	public void getProduct_whenProductDetailsAreAvailable_thenReturnResponse() throws Exception {

		List<Product> mockResponse = mockProducts();
		when(productService.findAll()).thenReturn(mockResponse);
		
		mockMvc.perform(get("/products")).andExpect(status().is(200));
	}

	public List<Product> mockProducts() {
		List<Product> list = new ArrayList<>();
		Product product = new Product();
		product.setId(100);
		product.setNoofproduct(6);
		product.setBatchno("A0001");
		product.setPname("Mobile");
		product.setPrice(9000.00);

		list.add(product);

		return list;
	}

}
