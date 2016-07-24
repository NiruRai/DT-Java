package com.niit.musichub.service;

import com.niit.musichub.model.UsersOrder;

public interface UsersOrderService {

    void addUsersOrder(UsersOrder customerOrder);

    double getUsersOrderGrandTotal(int grand);


}
