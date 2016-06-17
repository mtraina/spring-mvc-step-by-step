package com.mtraina.springapp.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;
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
		given(productService.getProducts()).willReturn(Lists.newArrayList(product));
				
		// when
		ModelAndView modelAndView = productController.handleRequest(null, null);
		
		// then
		Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
		List<Product> products = (List<Product>) modelMap.get("products");
		assertThat(products).containsOnly(product);
	}

}
