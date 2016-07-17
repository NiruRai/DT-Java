package com.niit.musichub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.musichub.model.Category;
import com.niit.musichub.service.CategoryService;

@Controller
@RequestMapping("/admin")
public class AdminCategoryController {
	
	@Autowired
	CategoryService cse;
	
	@RequestMapping(value = "/addCategory", method = RequestMethod.GET)
	public ModelAndView list() {
		List<Category> list = cse.list();
		return new ModelAndView("addCategory", "category", list);
	}

	// For add and update product both
	@ModelAttribute("categorycommand")
	public Category newCategory() {
		return new Category();
	}

	@RequestMapping(value = "/category/add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("categorycommand") Category c, BindingResult result) {

		if (result.hasErrors()) 
		{
			return "addCategory";
		}
		
		System.out.println(c.getCid());
		
		cse.saveOrUpdate(c);

		

		return "redirect:/admin/addCategory";
	}

	@RequestMapping("/category/remove/{id}")
	public String deleteCategory(@PathVariable("id") String id, ModelMap model) throws Exception {

		try {
			cse.delete(id);
			model.addAttribute("message", "Successfully deleted");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		// redirectAttrs.addFlashAttribute(arg0, arg1)
		return "redirect:/admin/addCategory";
	}

	@RequestMapping("/category/edit/{id}")
	public String editProduct(@PathVariable("id") String id, Model model) {
		System.out.println("editCategory");
		model.addAttribute("categorycommand", this.cse.get(id));
		model.addAttribute("listCategory", this.cse.list());
		return "addCategory";
	}


}



