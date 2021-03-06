package com.stk.academy.batch.jdbc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.stk.academy.batch.jdbc.data.domain.CartEntity;
import com.stk.academy.batch.jdbc.services.CartService;

@Controller
@RequestMapping("carts")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value="list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String listCart(Model model){
		List<CartEntity> carts = cartService.findAllCarts();
		model.addAttribute("carts", carts);
		return "carts/index";
		
	}
	
	@RequestMapping(value="/show/{cartId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView showCart(@PathVariable("cartId") Long cartId){
		ModelAndView model = new ModelAndView("carts/edit");
		model.addObject("cart", cartService.findCartById(cartId));
		return model;
		
	}

}
