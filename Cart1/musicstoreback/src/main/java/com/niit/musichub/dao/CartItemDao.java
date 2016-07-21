package com.niit.musichub.dao;

import com.niit.musichub.model.Cart;
import com.niit.musichub.model.CartItem;

public interface CartItemDao {
	
	void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(int productId);


}
