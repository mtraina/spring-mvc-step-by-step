package com.mtraina.springapp.builder;

import com.mtraina.springapp.domain.Product;

public class ProductBuilder {
	private String description;
	private Double price;
	
	private ProductBuilder(){}
	
	public static ProductBuilder instance(){
		return new ProductBuilder();
	}
	
	public ProductBuilder description(String description){
		this.description = description;
		return this;
	}
	
	public ProductBuilder price(Double price){
		this.price = price;
		return this;
	}
	
	public Product build(){
		Product product = new Product();
		product.setDescription(description);
		product.setPrice(price);
		return product;
	}
}
