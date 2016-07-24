package com.niit.musichub.controller;

import java.security.Principal;

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
	UsersService uservice;
	


    @RequestMapping
    public String getCart(Principal p){
        try {
			Users users = uservice.getUserByName(p.getName());
			int cartId = users.getCart().getCartId();
			
			return "redirect:/customer/cart/" + cartId;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "errorPage";
		}
    }

    @RequestMapping("/{cartId}")
    public String getCartRedirect(@PathVariable (value = "cartId") int cartId, Model model){
        try {
			model.addAttribute("cartId", cartId);
			System.out.println("CartIdController"+ cartId);
			return "cart";
			
		} 
        catch (Exception e) {
			return "errorPage";
		}
    }

} // The End of Class;
