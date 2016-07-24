package com.niit.musichub.service;

import com.niit.musichub.model.Cart;
import com.niit.musichub.model.CartItem;

public interface CartItemService {
	
	void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(String pid);

}