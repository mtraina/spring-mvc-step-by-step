package com.mtraina.springapp.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Sets;
import com.mtraina.springapp.builder.ProductBuilder;
import com.mtraina.springapp.domain.Product;
import com.mtraina.springapp.service.ProductService;

public class ProductControllerTest {
		
	@Test
	public void handleRequestView() throws Exception{
		// given
		ProductService productService = mock(ProductService.class);
		ProductController productController = new ProductController(productService);
		Product product = ProductBuilder.instance().description("desc").price(1D).build(); 
		given(productService.getProducts()).willReturn(Sets.newHashSet(product));
				
		// when
		ModelAndView modelAndView = productController.handleRequest(null, null);
		
		// then
		Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
		Set<Product> products = (Set<Product>) modelMap.get("products");
		assertThat(products).containsOnly(product);
	}

}
