package com.niit.musichub.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.musichub.dao.ProductDao;
import com.niit.musichub.dao.ProductDaoImpl;
import com.niit.musichub.dao.UserLoginDao;
import com.niit.musichub.dao.UserLoginDaoImpl;
import com.niit.musichub.model.Product;

@Controller
public class HomeController 
{


	@Autowired
	UserLoginDao ud;
	
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
	
	@RequestMapping("/isValidUser")
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
	}
}
