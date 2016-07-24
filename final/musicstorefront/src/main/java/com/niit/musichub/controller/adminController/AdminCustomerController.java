package com.niit.musichub.controller.adminController;

import java.io.File;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.niit.musichub.model.Category;
import com.niit.musichub.model.Product;
import com.niit.musichub.model.Supplier;
import com.niit.musichub.model.UserLogin;
import com.niit.musichub.model.Users;
import com.niit.musichub.service.UserLoginService;
import com.niit.musichub.service.UsersService;

@Controller
@RequestMapping("/admin")
public class AdminCustomerController {
	
	@Autowired
	UsersService userService;
	UserLoginService userLoginServe;
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
	public String listProducts(Model model) {
		model.addAttribute("users", new Users());
		model.addAttribute("userlogin", new UserLogin());
		model.addAttribute("userList", this.userService.list());
		return "addCustomer";
	}
	
	@ModelAttribute("customercommand")
	public Users newUsers() {
		return new Users();
	}
	
	@RequestMapping(value = "/customer/add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("customercommand") Users users, HttpServletRequest request,
			BindingResult result) {

		if (result.hasErrors()) 
		{
			return "/error";
		}
		
		

		userService.saveOrUpdate(users);
		
		return "redirect:/admin/addCustomer";
	}

	

	@RequestMapping("/customer/edit/{id}")
	public String editProduct(@PathVariable("id") int id, Model model) {
		System.out.println("editCustomer");
	
		model.addAttribute("customercommand", this.userService.get(id));
		model.addAttribute("userServiceList", this.userService.list());

		return "addCustomer";
		
		
	}
}
