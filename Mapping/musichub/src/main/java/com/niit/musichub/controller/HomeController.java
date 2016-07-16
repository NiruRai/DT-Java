package com.niit.musichub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.niit.musichub.service.UserService;

@Controller
public class HomeController 
{


	@Autowired
	UserService ud;
	
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
