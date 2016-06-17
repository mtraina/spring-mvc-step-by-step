package com.mtraina.springapp.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.mtraina.springapp.dto.PriceIncrease;
import com.mtraina.springapp.service.ProductService;

public class PriceIncreaseFormController extends SimpleFormController {
	private final ProductService productService;
	
	public PriceIncreaseFormController(ProductService productService){
		this.productService = productService;
	}

    public ModelAndView onSubmit(Object command) throws ServletException {

        int increase = ((PriceIncrease) command).getPercentage();
        logger.info("Increasing prices by " + increase + "%.");

        productService.increasePrice(increase);

        logger.info("returning from PriceIncreaseForm view to " + getSuccessView());

        return new ModelAndView(new RedirectView(getSuccessView()));
    }

    protected Object formBackingObject(HttpServletRequest request) throws ServletException {
        PriceIncrease priceIncrease = new PriceIncrease();
        priceIncrease.setPercentage(20);
        return priceIncrease;
    }
}
