package com.demo.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.app.exception.ResourceNotFoundException;
import com.demo.app.model.Product;
import com.demo.app.response.ApiResponse;
import com.demo.app.response.util.ResponseUtil;
import com.demo.app.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/v1")
public class DemoController {
	
	@Autowired
	ProductService productService;

	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<Product>> getProductById(@PathVariable Long id, HttpServletRequest request) throws ResourceNotFoundException {
		// Fetch product by id (dummy code)
		Product product = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
		
		ApiResponse<Product> response = ResponseUtil.success(product, "Product fetched successfully", request.getRequestURI());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ApiResponse<Product>> createProduct(@RequestBody Product product,
			HttpServletRequest request) {
		// Create new product (dummy code)
		Product createdProduct = productService.save(product);
		ApiResponse<Product> response = ResponseUtil.success(createdProduct, "Product created successfully",
				request.getRequestURI());
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

}
