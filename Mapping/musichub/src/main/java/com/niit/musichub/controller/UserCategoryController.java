package com.niit.musichub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.musichub.model.Product;
import com.niit.musichub.service.ProductService;

@Controller
public class UserCategoryController {
	
	@Autowired
	ProductService pdo;
	
	@RequestMapping(value = "/userCategory", method = RequestMethod.GET)
	public ModelAndView list() {
		List<Product> list = pdo.list();
		return new ModelAndView("userCategory", "product", list);
	}

}
