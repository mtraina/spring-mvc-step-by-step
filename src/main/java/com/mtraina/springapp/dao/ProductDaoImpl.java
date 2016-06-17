package com.mtraina.springapp.dao;

import java.util.Set;

import com.google.common.collect.Sets;
import com.mtraina.springapp.builder.ProductBuilder;
import com.mtraina.springapp.domain.Product;

public class ProductDaoImpl implements ProductDao {

	public Set<Product> findProducts() {
		return Sets.newHashSet(
				ProductBuilder.instance().description("apple").price(1D).build(),
				ProductBuilder.instance().description("pear").price(2D).build(),
				ProductBuilder.instance().description("banana").price(0.8D).build());
	}

}
