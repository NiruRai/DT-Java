package com.niit.musichub.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.musichub.dao.CategoryDao;
import com.niit.musichub.model.Category;
import com.niit.musichub.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryDao cdo;

	public List<Category> list() {
		
		return cdo.list();
	}

	public Category get(String id) {
		
		return cdo.get(id);
	}

	public void saveOrUpdate(Category category) {
		cdo.saveOrUpdate(category);
		
	}

	public void delete(String id) {
		cdo.delete(id);
		
	}

	public Category getByName(String name) {
		
		return cdo.getByName(name);
	}

}
