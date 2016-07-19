package com.niit.musichub.service.serviceImpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.musichub.dao.CartDao;
import com.niit.musichub.model.Cart;
import com.niit.musichub.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	CartDao cartdao;

	public Cart getCartById(int cartId) {
		
		return cartdao.getCartById(cartId);
	}

	public Cart validate(int cartId) throws IOException {
		
		return cartdao.validate(cartId);
	}

	public void update(Cart cart) {
		cartdao.update(cart);
		
	}

}
