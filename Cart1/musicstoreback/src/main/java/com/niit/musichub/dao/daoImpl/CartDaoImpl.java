package com.niit.musichub.dao.daoImpl;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.io.IOException;


import com.niit.musichub.dao.CartDao;
import com.niit.musichub.dao.UsersOrderDao;
import com.niit.musichub.model.Cart;


@Repository
@Transactional
public class CartDaoImpl implements CartDao {
	
	public CartDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private UsersOrderDao usersOrderDao;
	
	public Cart getCartById(int cartId){
        Session session = sessionFactory.getCurrentSession();
        return (Cart) session.get(Cart.class, cartId);
    }

    public void update(Cart cart){
        int cartId = cart.getCartId();
        double grandTotal = usersOrderDao.getUsersOrderGrandTotal(cartId);
        cart.setGrandTotal(grandTotal);

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
    }

    public Cart validate(int cartId) throws IOException{
        Cart cart = getCartById(cartId);
        if(cart == null || cart.getCartItems().size() == 0){
            throw new IOException(cartId + "");
        }

        update(cart);
        return cart;
    }


}
