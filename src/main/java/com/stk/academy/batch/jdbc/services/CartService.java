package com.stk.academy.batch.jdbc.services;

import java.util.List;

import com.stk.academy.batch.jdbc.data.domain.CartEntity;

public interface CartService {
	
	CartEntity addCart(CartEntity cartEntity);
	CartEntity updateCart(CartEntity cartEntity);
	CartEntity findCartById(Long id);
	List<CartEntity> findAllCarts();
	boolean removeCart(Long id);
	

}
