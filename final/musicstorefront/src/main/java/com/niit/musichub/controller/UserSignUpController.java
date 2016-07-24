package com.niit.musichub.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.musichub.model.BillingAddress;
import com.niit.musichub.model.Product;
import com.niit.musichub.model.ShippingAddress;
import com.niit.musichub.model.Users;
import com.niit.musichub.service.UsersService;

@Controller
public class UserSignUpController {
	
	@Autowired
    private UsersService userService;
	
	@RequestMapping("/signUp")
	public String signUp(){
		
		return "signUp";
		
	}
	@ModelAttribute("registerCommand")
	public Users createUser() {
		Users user = new Users();
        BillingAddress billingAddress = new BillingAddress();
        ShippingAddress shippingAddress = new ShippingAddress();
        user.setBillingAddress(billingAddress);
        user.setShippingAddress(shippingAddress);
        return user;
		
	}

    @RequestMapping("/register")
    public String registerCustomer(Model model){
        Users user = new Users();
        BillingAddress billingAddress = new BillingAddress();
        ShippingAddress shippingAddress = new ShippingAddress();
        user.setBillingAddress(billingAddress);
        user.setShippingAddress(shippingAddress);
        model.addAttribute("user", user);
        return "signUp";
    }

	    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerCustomerPost(@ModelAttribute("registerCommand") Users user, BindingResult result, Model model){

        if(result.hasErrors()){
            return "signUp";
        }
        System.out.println(user.getBillingAddress().getCity());
        System.out.println("inside controller"+user.getUserid());
        userService.addUser(user);
       // user.setEnabled(true);
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        /*List<Users> customerList = userService.list();
        for (int i=0; i< customerList.size(); i++){
            if(user.getUseremail().equals(customerList.get(i).getUseremail())){
                model.addAttribute("emailMsg", "Email already exists");

                return "signUp";
            }

            if(user.getUsername().equals(customerList.get(i).getUsername())){
                model.addAttribute("usernameMsg", "Username already exists");

                return "signUp";
            }
        }*/

        //userService.saveOrUpdate(user);
        return "redirect:/registerConfirmed";
    }

	    @RequestMapping("/registerConfirmed")
		public String registerConfirmed(){
			
			return "registerConfirmed";
			
		}

}
