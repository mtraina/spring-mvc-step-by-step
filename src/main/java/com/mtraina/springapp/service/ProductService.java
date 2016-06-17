package com.mtraina.springapp.service;

import java.util.Set;

import com.mtraina.springapp.domain.Product;

public interface ProductService {
	
	Set<Product> getProducts();
	
	void increasePrice(int percentage);

}
