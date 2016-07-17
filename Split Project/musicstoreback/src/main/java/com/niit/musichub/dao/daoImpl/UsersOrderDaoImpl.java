package com.niit.musichub.dao.daoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.musichub.dao.CartDao;
import com.niit.musichub.dao.UsersOrderDao;
import com.niit.musichub.model.Cart;
import com.niit.musichub.model.CartItem;
import com.niit.musichub.model.UsersOrder;

@Repository
@Transactional
public class UsersOrderDaoImpl implements UsersOrderDao{
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Autowired
	private CartDao cartDao;

    public void addUsersOrder(UsersOrder usersOrder){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(usersOrder);
        session.flush();
    }
    
    public double getUsersOrderGrandTotal(int grand){
        double grandTotal = 0;
        Cart cart = cartDao.getCartById(grand);
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems){
            grandTotal += item.getTotalPrice();
        }

        return grandTotal;
    }


}
