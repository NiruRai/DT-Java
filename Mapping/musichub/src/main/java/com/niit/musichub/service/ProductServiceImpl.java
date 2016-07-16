package com.niit.musichub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.musichub.dao.ProductDao;
import com.niit.musichub.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao pdo;

	public List<Product> list() {
		
		return pdo.list();
	}

	public Product get(String id) {
		
		return pdo.get(id);
	}

	public void saveOrUpdate11(Product product) {
		
		pdo.saveOrUpdate11(product);
		
	}

	public void delete(String id) {
		pdo.delete(id);
		
	}

}
