package com.stk.academy.batch.jdbc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stk.academy.batch.jdbc.data.domain.CartEntity;
import com.stk.academy.batch.jdbc.repositories.CartRepository;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepository;

	public CartEntity addCart(CartEntity cartEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	public CartEntity updateCart(CartEntity cartEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	public CartEntity findCartById(Long id) {
		// TODO Auto-generated method stub
		return cartRepository.findOne(id);
	}

	public List<CartEntity> findAllCarts() {
		return cartRepository.list();
	}

	public boolean removeCart(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
