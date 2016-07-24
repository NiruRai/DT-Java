package com.niit.musichub.dao;

import com.niit.musichub.model.UsersOrder;

public interface UsersOrderDao {
	
	void addUsersOrder(UsersOrder usersOrder);
	
	double getUsersOrderGrandTotal(int grand);

}
