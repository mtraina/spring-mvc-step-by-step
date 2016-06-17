package com.mtraina.springapp.service;

import java.util.List;

import com.mtraina.springapp.dao.ProductDao;
import com.mtraina.springapp.domain.Product;

public class ProductServiceImpl implements ProductService {
	private final ProductDao productDao;
	
	public ProductServiceImpl(ProductDao productDao){
		this.productDao = productDao;
	}
	
	public List<Product> getProducts() {
		return productDao.findProducts();
	}

	public void increasePrice(int percentage) {
		//productDao.findProducts().stream()
	}
}
