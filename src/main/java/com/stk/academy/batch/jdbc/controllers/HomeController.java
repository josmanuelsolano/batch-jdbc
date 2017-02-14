package com.stk.academy.batch.jdbc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */


@Controller
@RequestMapping("/")
public class HomeController {
	
	//private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("cart", "pagina de inicio");
		return "home";
	}
	
}
