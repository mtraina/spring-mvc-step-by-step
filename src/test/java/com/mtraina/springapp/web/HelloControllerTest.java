package com.mtraina.springapp.web;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.*;

public class HelloControllerTest {
	
	@Test
	public void handleRequestView() throws Exception {
		HelloController controller = new HelloController();
		ModelAndView modelAndView = controller.handleRequest(null, null);
		assertThat(modelAndView.getViewName()).isEqualTo("hello");
		assertThat(modelAndView.getModel()).isNotNull();
		assertThat(modelAndView.getModel().get("now")).isNotNull();
	}
}
