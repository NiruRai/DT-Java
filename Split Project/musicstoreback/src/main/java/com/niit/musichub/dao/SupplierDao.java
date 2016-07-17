package com.niit.musichub.dao;

import java.util.List;

import com.niit.musichub.model.Supplier;

public interface SupplierDao {
	
	public List<Supplier> list();
	
	public Supplier get(String id);
	
	public void saveOrUpdate(Supplier supplier);
	
	public void delete(String id);
	
	public Supplier getByName(String name);

}
