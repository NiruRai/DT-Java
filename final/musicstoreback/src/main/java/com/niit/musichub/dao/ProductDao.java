package com.niit.musichub.dao;

import java.util.List;
import com.niit.musichub.model.Product;

public interface ProductDao {
	
	public List<Product> list();
	
	public Product get(String id);
	
	public void saveOrUpdate11(Product product);
	
	public void delete(String id);

}
