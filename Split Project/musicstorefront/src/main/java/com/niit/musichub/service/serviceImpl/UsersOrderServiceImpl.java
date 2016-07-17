package com.niit.musichub.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.musichub.dao.UsersOrderDao;
import com.niit.musichub.model.Cart;
import com.niit.musichub.model.CartItem;
import com.niit.musichub.model.UsersOrder;
import com.niit.musichub.service.CartService;
import com.niit.musichub.service.UsersOrderService;

@Service
public class UsersOrderServiceImpl implements UsersOrderService{
	
	@Autowired
    private UsersOrderDao usersOrderDao;

    public void addUsersOrder(UsersOrder usersOrder){
    	usersOrderDao.addUsersOrder(usersOrder);
    }

	public double getUsersOrderGrandTotal(int grand) {
		
		return usersOrderDao.getUsersOrderGrandTotal(grand);
	}

   


}
