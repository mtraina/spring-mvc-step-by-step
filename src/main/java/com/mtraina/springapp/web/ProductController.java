package com.mtraina.springapp.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.google.common.collect.ImmutableMap;
import com.mtraina.springapp.service.ProductService;

public class ProductController implements Controller {
	private final ProductService productService;
	
	public ProductController(ProductService productService){
		this.productService = productService;
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String now = (new java.util.Date()).toString();
        Map<String, Object> model = ImmutableMap.of("now", now, "products", productService.getProducts());
        return new ModelAndView("hello", "model", model);
	}

}
