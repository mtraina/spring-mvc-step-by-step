package com.mtraina.springapp.service;

import org.junit.Ignore;
import org.junit.Test;

import com.mtraina.springapp.builder.ProductBuilder;
import com.mtraina.springapp.dao.ProductDao;
import com.mtraina.springapp.dao.ProductDaoImpl;
import com.mtraina.springapp.domain.Product;

import static org.assertj.core.api.Assertions.*;

public class ProductServiceTest {
	
	@Test
	@Ignore
	public void getNoProducts(){
		// given
		ProductDao productDao = new ProductDaoImpl();
		ProductService productService = new ProductServiceImpl(productDao);
		
		Product p1 = ProductBuilder.instance().description("apple").price(1D).build();
		Product p2 = ProductBuilder.instance().description("pear").price(2D).build();
		Product p3 = ProductBuilder.instance().description("banana").price(0.8D).build();
		
		// when - then
		assertThat(productService.getProducts()).containsOnly(p1, p2, p3);
	}

}
