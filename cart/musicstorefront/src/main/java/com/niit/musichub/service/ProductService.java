package com.niit.musichub.service;

import java.util.List;

import com.niit.musichub.model.Product;

public interface ProductService {
	
public List<Product> list();
	
	public Product get(String id);
	
	public void saveOrUpdate11(Product product);
	
	public void delete(String id);

}
