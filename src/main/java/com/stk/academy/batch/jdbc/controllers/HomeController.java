package com.stk.academy.batch.jdbc.controllers;

import org.springframework.http.MediaType;
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


	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public String home( Model model) {
		model.addAttribute("carts", "HOME");
		
		return "home";
	}
	
}
