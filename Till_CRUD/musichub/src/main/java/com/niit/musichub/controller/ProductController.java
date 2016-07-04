package com.niit.musichub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.niit.musichub.dao.ProductDao;
import com.niit.musichub.model.Product;

@Controller
public class ProductController {

	@Autowired
	ProductDao pdi;

	@RequestMapping(value = "/allCategory", method = RequestMethod.GET)
	public ModelAndView list() {
		List<Product> list = pdi.list();
		return new ModelAndView("allCategory", "product", list);
	}

	// For add and update product both
	@ModelAttribute("productcommand")
	public Product newProduct() {
		return new Product();
	}

	@RequestMapping(value = "/product/add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("productcommand") Product p, BindingResult result) {
		if (result.hasErrors()) {
			return "allCategory";
		}
		System.out.println(p.getPid());
		pdi.saveOrUpdate11(p);

		return "redirect:/allCategory";

	}

	@RequestMapping("product/remove/{id}")
	public String deleteCategory(@PathVariable("id") String id, ModelMap model) throws Exception {

		try {
			pdi.delete(id);
			model.addAttribute("message", "Successfully deleted");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		// redirectAttrs.addFlashAttribute(arg0, arg1)
		return "redirect:/allCategory";
	}

	@RequestMapping("product/edit/{id}")
	public String editProduct(@PathVariable("id") String id, Model model) {
		System.out.println("editProduct");
		model.addAttribute("productcommand", this.pdi.get(id));
		model.addAttribute("listProducts", this.pdi.list());
		return "allCategory";
	}

}
