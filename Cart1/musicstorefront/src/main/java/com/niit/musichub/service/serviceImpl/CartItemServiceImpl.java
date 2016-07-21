package com.niit.musichub.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.musichub.dao.CartItemDao;
import com.niit.musichub.model.Cart;
import com.niit.musichub.model.CartItem;
import com.niit.musichub.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService{
	
	public CartItemServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	CartItemDao cartItemDao;
	
	public void addCartItem(CartItem cartItem){
        cartItemDao.addCartItem(cartItem);
    }

    public void removeCartItem(CartItem cartItem){
        cartItemDao.removeCartItem(cartItem);
    }

    public void removeAllCartItems(Cart cart){
        cartItemDao.removeAllCartItems(cart);
    }

    public CartItem getCartItemByProductId(int productItem){
        return cartItemDao.getCartItemByProductId(productItem);
    }


}
