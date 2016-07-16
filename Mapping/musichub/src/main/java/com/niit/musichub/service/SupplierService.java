package com.niit.musichub.service;

import java.util.List;

import com.niit.musichub.model.Supplier;

public interface SupplierService {
	
public List<Supplier> list();
	
	public Supplier get(String id);
	
	public void saveOrUpdate(Supplier supplier);
	
	public void delete(String id);

}
