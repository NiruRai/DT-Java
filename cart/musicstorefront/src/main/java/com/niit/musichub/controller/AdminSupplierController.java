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

import com.niit.musichub.model.Supplier;
import com.niit.musichub.service.SupplierService;

@Controller
@RequestMapping("/admin")
public class AdminSupplierController {
	
	@Autowired
	SupplierService sse;
	
	@RequestMapping(value = "/addSupplier", method = RequestMethod.GET)
	public ModelAndView list() {
		List<Supplier> list = sse.list();
		return new ModelAndView("addSupplier", "supplier", list);
	}

	// For add and update product both
	@ModelAttribute("suppliercommand")
	public Supplier newSupplier() {
		return new Supplier();
	}

	@RequestMapping(value = "/supplier/add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("suppliercommand") Supplier s, BindingResult result) {

		if (result.hasErrors()) 
		{
			return "addSupplier";
		}
		
		System.out.println(s.getSid());
		
		sse.saveOrUpdate(s);

		

		return "redirect:/admin/addSupplier";
	}

	@RequestMapping("/supplier/remove/{id}")
	public String deleteCategory(@PathVariable("id") String id, ModelMap model) throws Exception {

		try {
			sse.delete(id);
			model.addAttribute("message", "Successfully deleted");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		// redirectAttrs.addFlashAttribute(arg0, arg1)
		return "redirect:/admin/addSupplier";
	}

	@RequestMapping("/supplier/edit/{id}")
	public String editProduct(@PathVariable("id") String id, Model model) {
		System.out.println("editSupplier");
		model.addAttribute("suppliercommand", this.sse.get(id));
		model.addAttribute("listSupplier", this.sse.list());
		return "addSupplier";
	}



}
