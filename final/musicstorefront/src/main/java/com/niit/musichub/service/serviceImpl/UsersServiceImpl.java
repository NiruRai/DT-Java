package com.niit.musichub.service.serviceImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.musichub.dao.UsersDao;
import com.niit.musichub.model.Authority;
import com.niit.musichub.model.BillingAddress;
import com.niit.musichub.model.Cart;
import com.niit.musichub.model.ShippingAddress;
import com.niit.musichub.model.UserLogin;
import com.niit.musichub.model.Users;
import com.niit.musichub.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	UsersDao udo;
	
	public UsersServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	public UsersServiceImpl(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;

	}

	public List<Users> list() {
		
		return udo.list();
	}

	public Users get(int id) {
		
		return udo.get(id);
	}

	public void saveOrUpdate(Users users) {

		udo.saveOrUpdate(users);
		
	}

	public void delete(int id) {

		udo.delete(id);
		
	}

	public Users getUserByName(String username) {
		
		return udo.getUserByName(username);
	}

	public void addUser(Users user) {
		/*Session session = sessionFactory.getCurrentSession();*/
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		/*user.getBillingAddress().setUser(user);
		user.getShippingAddress().setUsers(user);*/
		System.out.println("inside serviceimpl"+user.getUserid());
       udo.addUser(user);
	}

}
