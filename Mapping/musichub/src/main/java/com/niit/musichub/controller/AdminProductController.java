package com.niit.musichub.controller;

import java.io.File;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.niit.musichub.model.Product;
import com.niit.musichub.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminProductController {
	
	private Path path;

	@Autowired
	ProductService pdi;

	@RequestMapping
	public String home() {
		return "adminHome";
	}

	@RequestMapping("/aboutUs")
	public String aboutUs() {
		return "aboutus";
	}

	@RequestMapping("/contactUs")
	public String contactUs() {
		return "contactUs";
	}

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
	public String addProduct(@ModelAttribute("productcommand") Product p, HttpServletRequest request,
			BindingResult result) {

		if (result.hasErrors()) 
		{
			return "allCategory";
		}
		
		System.out.println(p.getPid());
		
		pdi.saveOrUpdate11(p);

		MultipartFile productImage=p.getImage();
		
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");

		path=Paths.get(rootDirectory+"/WEB-INF/resources/images"+p.getPid()+".png");

		System.out.println("Path = " + path);

		System.out.println("File name = " + p.getImage().getOriginalFilename());

		if (productImage!=null && !productImage.isEmpty())

		{
			try

			{
				// filename=p.getImage().getOriginalFilename();
				productImage.transferTo(new File(path.toString()));
				System.out.println("Image uploaded");
			} 
			catch (Exception ex)
			{

				System.out.println(ex.getMessage());

			}
		}

		return "redirect:/admin/allCategory";
	}

	@RequestMapping("/product/remove/{id}")
	public String deleteCategory(@PathVariable("id") String id, ModelMap model) throws Exception {

		try {
			pdi.delete(id);
			model.addAttribute("message", "Successfully deleted");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			e.printStackTrace();
		}
		// redirectAttrs.addFlashAttribute(arg0, arg1)
		return "redirect:/admin/allCategory";
	}

	@RequestMapping("/product/edit/{id}")
	public String editProduct(@PathVariable("id") String id, Model model) {
		System.out.println("editProduct");
		model.addAttribute("productcommand", this.pdi.get(id));
		model.addAttribute("listProducts", this.pdi.list());
		return "allCategory";
	}

	@RequestMapping(value = "/userCategory", method = RequestMethod.GET)
	public ModelAndView clist() {
		List<Product> list = pdi.list();
		return new ModelAndView("userCategory", "product", list);
	}

}
