package com.niit.musichub.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.musichub.dao.CategoryDao;
import com.niit.musichub.model.Category;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	
	public CategoryDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public CategoryDaoImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;

	}

	public List<Category> list() {
			@SuppressWarnings("unchecked")
			List<Category> listCategory  = (List<Category>) sessionFactory.getCurrentSession().createQuery("from Category").list();
			return listCategory;
	}

	public Category get(String id) {
		String hql = "from Category where cid=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) query.list();
		if (listCategory != null && !listCategory.isEmpty()) {
			return listCategory.get(0);
		}
		else
		{
			return null;			
		}

	}


	public void saveOrUpdate(Category category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		
	}

	public void delete(String id) {
		Category CategoryToDelete = new Category();
		CategoryToDelete.setCid(id);
		sessionFactory.getCurrentSession().delete(CategoryToDelete);
		
	}

	public Category getByName(String name) {
		String hql="from Category where cname=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, name);
		@SuppressWarnings("unchecked")
		List<Category> listCategory=(List<Category>) query.list();
		if (listCategory != null && !listCategory.isEmpty()) {
			return listCategory.get(0);
		}
		else
		{
			return null;			
		}

	}
}
