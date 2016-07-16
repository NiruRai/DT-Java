package com.niit.musichub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.musichub.dao.SupplierDao;
import com.niit.musichub.model.Supplier;

@Service
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	SupplierDao sdo;

	public List<Supplier> list() {
		
		return sdo.list();
	}

	public Supplier get(String id) {
		
		return sdo.get(id);
	}

	public void saveOrUpdate(Supplier supplier) {

		sdo.saveOrUpdate(supplier);
		
	}

	public void delete(String id) {
		
		sdo.delete(id);
		
	}

}
