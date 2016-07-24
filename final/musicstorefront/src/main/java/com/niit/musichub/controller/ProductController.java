package com.niit.musichub.controller;

import com.niit.musichub.model.Category;
import com.niit.musichub.model.Product;
import com.niit.musichub.model.Supplier;
import com.niit.musichub.service.CategoryService;
import com.niit.musichub.service.ProductService;
import com.niit.musichub.service.SupplierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

@Controller

public class ProductController {

    @Autowired
    private ProductService productService;
    
    @Autowired
	CategoryService cdo;
	
	@Autowired
	SupplierService sdo;
    
    /*@Autowired
	private JavaMailSender mailSender;*/

    /*@RequestMapping("/productList/all")
    public String getProducts(Model model){
        List<Product> products = productService.list();
        model.addAttribute("products", products);

        return "userCategory";
    }*/

    @RequestMapping("/product/viewProduct/{productId}")
    public String viewProduct(@PathVariable String productId, Model model) throws IOException{
        Product product = productService.get(productId);
        model.addAttribute("product", product);
        return "productPage";
    }

    @RequestMapping("/productList")
    public String getProductByCategory(@RequestParam("searchCondition") String searchCondition, Model model){
    //   System.out.println(searchCondition);
    	List<Product> productList = productService.list();
    	List<Product> al=new ArrayList<Product>();
    	Iterator i=productList.iterator();
    	while(i.hasNext())
    	{
    		Product p=(Product)i.next();
    		if(p.getName().equals(searchCondition))
    			al.add(p);
    	}
    	model.addAttribute("productList", al);
        model.addAttribute("searchCondition", searchCondition);

        return "userCategory";
    }
    @RequestMapping("/product/favorite/{pid}")
    public String viewSendMailPage(@PathVariable String pid, Model model) throws IOException{
    	Product product = productService.get(pid);
        model.addAttribute("product", product);
        model.addAttribute("subject","My favorite");
        String url=PageContext.REQUEST.toString();
        model.addAttribute("msg","Dear All,\n \n Greeting from MusicHub \n\n Like this Product, Please click on the below link tp view the product"+url);
        return "sendMail";
    }
    /*
    @RequestMapping(value="/sendMail", method=RequestMethod.POST)
    public String sendMail(HttpServletRequest request)
    {
    	try
		{
		String recipientAddress = request.getParameter("recipient");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		
		// prints debug info
		System.out.println("To: " + recipientAddress);
		System.out.println("Subject: " + subject);
		System.out.println("Message: " + message);
		
		// creates a simple e-mail object
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message);
		
		// sends the e-mail
		mailSender.send(email);
		
		
		}
		catch(Exception ex)
		{
			System.out.println("Exception = "+ex);
		}
		return "Success";
    }*/
    
   

} 
