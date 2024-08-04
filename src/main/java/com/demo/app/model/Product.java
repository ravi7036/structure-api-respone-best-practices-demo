package com.demo.app.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Product {
	
	private long id;
	private String productName;
	private BigDecimal price;
	private String description;

}
