package com.niit.musichub.daoImpl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.musichub.dao.UsersDao;
import com.niit.musichub.model.Authority;
import com.niit.musichub.model.BillingAddress;
import com.niit.musichub.model.Cart;
import com.niit.musichub.model.ShippingAddress;
import com.niit.musichub.model.UserLogin;
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
		String hql="from Users where userloginname=:unm";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("unm", username);
		
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

	public void addUser(Users user) {
		 System.out.println(user.getBillingAddress().getCity());
	        BillingAddress billingAddress = user.getBillingAddress();
	        ShippingAddress shippingAddress = user.getShippingAddress();
	        user.setBillingAddress(billingAddress);
	        user.setShippingAddress(shippingAddress);
			sessionFactory.getCurrentSession().saveOrUpdate(billingAddress);
			sessionFactory.getCurrentSession().saveOrUpdate(shippingAddress);
			//sessionFactory.getCurrentSession().saveOrUpdate(user);
			System.out.println("inside daoimpl"+user.getUserid());
			UserLogin newUser = new UserLogin();
			newUser.setUsersId(user.getUserid());
			newUser.setUsername(user.getUserloginname());
			newUser.setPassword(user.getUserloginpassword());
			newUser.setEnabled(true);
			newUser.setCustomerId(user.getUserid());
			
			Authority authority = new Authority();
			authority.setUsername(newUser.getUsername());
			authority.setAuthority("ROLE_USER");
			
			sessionFactory.getCurrentSession().saveOrUpdate(newUser);
			sessionFactory.getCurrentSession().saveOrUpdate(authority);
			
			Cart newCart = new Cart();
			newCart.setUsers(user);
			user.setCart(newCart);
			user.setEnabled(true);
			sessionFactory.getCurrentSession().saveOrUpdate(newCart);
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			
			sessionFactory.getCurrentSession().flush();
			
		
	}

}
