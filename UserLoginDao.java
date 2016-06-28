package com.niit.musichub.dao;

import java.util.List;

import com.niit.musichub.model.UserLogin;

public interface UserLoginDao {
		
	public List<UserLogin> list();

	public UserLogin get(String id);

	public void saveOrUpdate(UserLogin userlogin);

	public void delete(String id);
	
	public boolean isValidUser(String id, String name);

	}



