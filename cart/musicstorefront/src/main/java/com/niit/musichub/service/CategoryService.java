package com.niit.musichub.service;

import java.util.List;

import com.niit.musichub.model.Category;

public interface CategoryService {
	
public List<Category> list();
	
	public Category get(String id);
	
	public void saveOrUpdate(Category category);
	
	public void delete(String id);
	
	public Category getByName(String name);

}
