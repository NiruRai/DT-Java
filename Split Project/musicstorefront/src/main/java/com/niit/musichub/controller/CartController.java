package com.niit.musichub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.musichub.model.Users;
import com.niit.musichub.service.UsersService;

@Controller
@RequestMapping("/customer/cart")
public class CartController {

	@Autowired
	private UsersService uservice;
	


    @RequestMapping
    public String getCart(@AuthenticationPrincipal User activeUser){
        Users users = uservice.getUserByName(activeUser.getUsername());
        int cartId = users.getCart().getCartId();

        return "redirect:/customer/cart/" + cartId;
    }

    @RequestMapping("/{cartId}")
    public String getCartRedirect(@PathVariable (value = "cartId") int cartId, Model model){
        model.addAttribute("cartId", cartId);

        return "cart";
    }

} // The End of Class;
