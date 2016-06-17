package com.mtraina.springapp.service;

import java.util.Set;

import com.mtraina.springapp.dao.ProductDao;
import com.mtraina.springapp.domain.Product;

public class ProductServiceImpl implements ProductService {
	private final ProductDao productDao;
	
	public ProductServiceImpl(ProductDao productDao){
		this.productDao = productDao;
	}
	
	public Set<Product> getProducts() {
		return productDao.findProducts();
	}

	public void increasePrice(int percentage) {
		//productDao.findProducts().stream()
	}
}
