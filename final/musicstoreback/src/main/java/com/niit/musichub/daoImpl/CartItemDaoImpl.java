package com.niit.musichub.daoImpl;

import java.util.List;


import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.musichub.dao.CartItemDao;
import com.niit.musichub.model.Cart;
import com.niit.musichub.model.CartItem;

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {
	
public CartItemDaoImpl() {
	// TODO Auto-generated constructor stub
}

    @Autowired
    private SessionFactory sessionFactory;

    public void addCartItem(CartItem cartItem){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cartItem);
        session.flush();
    }

    public void removeCartItem(CartItem cartItem){
        Session session = sessionFactory.getCurrentSession();
        session.delete(cartItem);
        System.out.println("samlkhfbjsdjshfjhfdbjhdcjhdcjhdcjhcjhdcjhn");
        session.flush();
        
    }

    public void removeAllCartItems(Cart cart){
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems){
            removeCartItem(item);
        }
    }

    public CartItem getCartItemByProductId(String productId){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CartItem where pid= :pid ");
        query.setString("pid",productId);
        System.out.println(query);
        session.flush();
        return (CartItem) query.uniqueResult();
    }



}
