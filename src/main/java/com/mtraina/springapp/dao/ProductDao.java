package com.mtraina.springapp.dao;

import java.util.List;

import com.mtraina.springapp.domain.Product;

public interface ProductDao {
	List<Product> findProducts();
	
	void saveProduct(Product product);
}
