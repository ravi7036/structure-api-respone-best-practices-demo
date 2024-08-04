package com.demo.app.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.demo.app.model.Product;
import com.demo.app.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	
	static List<Product> productsList = new ArrayList<>();
	static {
		productsList.add(new Product(101,"Product A", BigDecimal.valueOf(1000.00), "Demo Product A"));
		productsList.add(new Product(102,"Product B", BigDecimal.valueOf(20000.00), "Demo Product B"));
		productsList.add(new Product(103,"Product C", BigDecimal.valueOf(3000.00), "Demo Product C"));
		productsList.add(new Product(104,"Product D", BigDecimal.valueOf(6000.00), "Demo Product D"));
	}

	@Override
	public Optional<Product> findById(Long id) {
		return productsList.stream().filter(product -> product.getId() == id).findFirst();
	}

	@Override
	public Product save(Product product) {
		 productsList.add(product);
		 return product;
	}

}
