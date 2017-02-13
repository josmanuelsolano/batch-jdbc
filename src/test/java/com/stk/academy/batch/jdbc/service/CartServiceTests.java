package com.stk.academy.batch.jdbc.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.stk.academy.batch.jdbc.data.domain.CartEntity;
import com.stk.academy.batch.jdbc.repositories.CartRepository;
import com.stk.academy.batch.jdbc.services.CartService;
import com.stk.academy.batch.jdbc.services.CartServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CartServiceTests {
	
	@Mock
	private CartRepository cartRepository;
	
	@Autowired
	private CartService cartService;
	
	private CartEntity cart;
	
	@Test
	public void findAllCartsTest(){
		List<CartEntity> cars = cartService.findAllCarts();
		Assert.assertEquals(32, cars.size());
	} 

}
