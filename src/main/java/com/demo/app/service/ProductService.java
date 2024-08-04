package com.demo.app.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.app.model.Product;

@Service
public interface ProductService {

	Optional<Product> findById(Long id);

	Product save(Product product); 

}
