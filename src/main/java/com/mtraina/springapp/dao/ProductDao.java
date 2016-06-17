package com.mtraina.springapp.dao;

import java.util.Set;

import com.mtraina.springapp.domain.Product;

public interface ProductDao {
	Set<Product> findProducts();
}
