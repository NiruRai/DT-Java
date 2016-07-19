package com.niit.musichub.service;

import java.io.IOException;

import com.niit.musichub.model.Cart;

public interface CartService {
	
	Cart getCartById(int cartId);

    Cart validate(int cartId) throws IOException;

    void update(Cart cart);

}
