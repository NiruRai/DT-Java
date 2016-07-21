package com.niit.musichub.dao.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.musichub.dao.SupplierDao;
import com.niit.musichub.model.Supplier;

@Repository
@Transactional
public class SupplierDaoImpl implements SupplierDao{
	
	public SupplierDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SupplierDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;

	}

	public List<Supplier> list() {
			@SuppressWarnings("unchecked")
			List<Supplier> listSupplier  = (List<Supplier>) sessionFactory.getCurrentSession().createQuery("from Supplier").list();
			return listSupplier;
	}

	public Supplier get(String id) {
		String hql = "from Supplier where sid=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
		@SuppressWarnings("unchecked")
		List<Supplier> listSupplier = (List<Supplier>) query.list();
		if (listSupplier != null && !listSupplier.isEmpty()) {
			return listSupplier.get(0);
		}
		else
		{
			return null;			
		}

	}


	public void saveOrUpdate(Supplier supplier) {
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		
	}

	public void delete(String id) {
		Supplier SupplierToDelete = new Supplier();
		SupplierToDelete.setSid(id);
		sessionFactory.getCurrentSession().delete(SupplierToDelete);
		
	}

	public Supplier getByName(String name) {
		String hql="from Supplier where supname=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);
		
		@SuppressWarnings("unchecked")
		List<Supplier> listSupplier=(List<Supplier>) query.list();
		if(listSupplier!=null && !listSupplier.isEmpty()){
			
			return listSupplier.get(0);
		}
		else{
			
			return null;
		}
		
	}

}

