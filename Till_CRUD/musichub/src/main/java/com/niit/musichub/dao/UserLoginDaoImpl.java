package com.niit.musichub.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.musichub.model.UserLogin;

@Repository("UserLoginDao")
public class UserLoginDaoImpl implements UserLoginDao {
	
	public UserLoginDaoImpl(){
		
	}
		
	@Autowired
	private SessionFactory sessionFactory;


	public UserLoginDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<UserLogin> list() {
		@SuppressWarnings("unchecked")
		List<UserLogin> list = (List<UserLogin>) sessionFactory.getCurrentSession()
				.createCriteria(UserLogin.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return list;
	}

	@Transactional
	public void saveOrUpdate(UserLogin userlogin) {
		sessionFactory.getCurrentSession().saveOrUpdate(userlogin);
	}

	@Transactional
	public void delete(String id) {
		UserLogin user = new UserLogin();
		user.setU_id(id);
		sessionFactory.getCurrentSession().delete(user);
	}

	@Transactional
	public UserLogin get(String id) {
		String hql = "from User where id=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<UserLogin> list = (List<UserLogin>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		
		return null;
	}
	
	@Transactional
	public boolean isValidUser(String id, String password) {
		String hql = "from UserLogin where u_name=? and u_password=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
		query.setString(1, password);
		@SuppressWarnings("unchecked")
		List<UserLogin> list = query.list();
		
		if (list != null && !list.isEmpty()) {
			return true;
		}
		
		return false;
	}

	}