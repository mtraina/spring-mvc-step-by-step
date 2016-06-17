package com.mtraina.springapp.service;

import java.util.List;

import com.mtraina.springapp.domain.Product;

public interface ProductService {
	
	List<Product> getProducts();
	
	void increasePrice(int percentage);

}
