package com.niit.musichub.dao.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.niit.musichub.dao.ProductDao;
import com.niit.musichub.model.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

	public ProductDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private SessionFactory sessionFactory;

	public ProductDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;

	}
	
	
	public List<Product> list() {
		@SuppressWarnings("unchecked")
		List<Product> listProduct  = (List<Product>) sessionFactory.getCurrentSession().createQuery("from Product").list();
		return listProduct;
	}

	
	public void saveOrUpdate11(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);
	}

	
	public void delete(String id) {
		Product ProductToDelete = new Product();
		ProductToDelete.setPid(id);
		sessionFactory.getCurrentSession().delete(ProductToDelete);
	}

	
	public Product get(String id) {
		String hql = "from Product where pid=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) query.list();
		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct.get(0);
		}
		else
		{
			return null;			
		}

	}



}
