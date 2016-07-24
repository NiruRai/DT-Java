package com.niit.musichub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.musichub.model.Category;
import com.niit.musichub.model.Product;
import com.niit.musichub.model.Supplier;
import com.niit.musichub.service.CategoryService;
import com.niit.musichub.service.ProductService;
import com.niit.musichub.service.SupplierService;
import com.niit.musichub.service.UserLoginService;

@Controller
public class HomeController 
{

	@Autowired
	ProductService pdo;
	
	@Autowired
	CategoryService cdo;
	
	@Autowired
	SupplierService sdo;

	@Autowired
	UserLoginService ud;
	
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	
	@RequestMapping("/aboutUs")
	public String aboutUs()
	{
		return "aboutus";
	}
	
	@RequestMapping("/contactUs")
	public String contactUs()
	{
		return "contactUs";
	}
	
	
	
	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@RequestMapping("/loginSuccess")
	public String loginSuccess()
	{
		return "loginSuccess";
	}
	
	@RequestMapping("/userCategory")
	public String userCategory(){
		
		return "userCategory";
		
	}
	
	
		
	@RequestMapping(value = "/userCategory", method = RequestMethod.GET)
	public String listProducts(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("category", new Category());
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("productList", this.pdo.list());
		model.addAttribute("categoryList", this.cdo.list());
		model.addAttribute("supplierList", this.sdo.list());
		return "userCategory";
	}
	
	@RequestMapping("/error")
	public String error(){
		return "error";
	}
	
	@RequestMapping("/errorPage")
	public String errorPage(){
		return "errorPage";
	}
	
	/*@RequestMapping("/isValidUser")
	public ModelAndView showMessage(@RequestParam(value = "name") String name,
			@RequestParam(value = "password") String password) {
		System.out.println("in controller");
		System.out.println("username"+name);
		System.out.println("password"+password);
		//UserLoginDaoImpl ud=new UserLoginDaoImpl();
		String message;
		ModelAndView mv ;
		if (ud.isValidUser(name, password)==true) 
		{
			message = "Valid credentials";
			 mv = new ModelAndView("loginSuccess");
		} else {
			message = "Invalid credentials";
			 mv = new ModelAndView("login");
		}

		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
	}*/
}
