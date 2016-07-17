package com.niit.musichub.dao.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.musichub.dao.UsersDao;
import com.niit.musichub.model.Users;

@Repository
@Transactional
public class UsersDaoImpl implements UsersDao {
	
	public UsersDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private SessionFactory sessionFactory;
	
	public UsersDaoImpl(SessionFactory sessionFactory){
		
		this.sessionFactory = sessionFactory;
	}
	
	public List<Users> list() {
		@SuppressWarnings("unchecked")
		List<Users> listUsers  = (List<Users>) sessionFactory.getCurrentSession().createQuery("from Users").list();
		return listUsers;
	}

	public Users get(int id) {
		String hql= "from Users where userid=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		
		@SuppressWarnings("unchecked")
		List<Users> listUsers=(List<Users>) query.list();
		if(listUsers!=null && !listUsers.isEmpty()){
			
			return listUsers.get(0);
			
		}
		
		else
		{
			return null;			
		}

	}

	public void delete(int id) {
		Users UsersToDelete=new Users();
		UsersToDelete.setUserid(id);
		sessionFactory.getCurrentSession().delete(UsersToDelete);
		
	}
	public void saveOrUpdate(Users users) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(users);
		
	}

	public Users getUserByName(String username) {
		String hql="from Users where userid=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, username);
		
		@SuppressWarnings("unchecked")
		List<Users> listUsers=(List<Users>) query.list();
		if(listUsers!=null && !listUsers.isEmpty()){
			
			return listUsers.get(0);
			
		}
		else
		{
			return null;
		}
	}

}
