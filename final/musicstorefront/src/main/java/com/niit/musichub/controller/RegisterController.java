package com.niit.musichub.controller;

import com.niit.musichub.model.Cart;
import com.niit.musichub.model.Users;
import com.niit.musichub.model.UsersOrder;
import com.niit.musichub.service.CartService;
import com.niit.musichub.service.UsersOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UsersOrderService usersOrderService;

    @RequestMapping("/order/{cartId}")
    public String createOrder(@PathVariable("cartId") int cartId){
    	UsersOrder usersOrder = new UsersOrder();
        Cart cart = cartService.getCartById(cartId);
        usersOrder.setCart(cart);

        Users users = cart.getUsers();
        usersOrder.setUsers(users);
        usersOrder.setBillsaddress(users.getBillingAddress());
        usersOrder.setShipaddress(users.getShippingAddress());

        usersOrderService.addUsersOrder(usersOrder);

        return "redirect:/checkout?cartId=" + cartId;

    }

} // The End of Class;
