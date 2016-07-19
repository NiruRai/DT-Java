package com.niit.musichub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.musichub.model.Category;
import com.niit.musichub.model.Product;
import com.niit.musichub.model.Supplier;
import com.niit.musichub.service.CategoryService;
import com.niit.musichub.service.ProductService;
import com.niit.musichub.service.SupplierService;

@Controller
public class UserCategoryController {
	
	@Autowired
	ProductService pdo;
	
	@Autowired
	CategoryService cdo;
	
	@Autowired
	SupplierService sdo;
	
	/*@RequestMapping(value = "/userCategory", method = RequestMethod.GET)
	public ModelAndView list() {
		List<Product> list = pdo.list();
		return new ModelAndView("userCategory", "product", list);
	}*/

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
}
