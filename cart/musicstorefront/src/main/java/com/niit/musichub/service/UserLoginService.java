package com.niit.musichub.service;

import java.util.List;

import com.niit.musichub.model.UserLogin;

public interface UserLoginService {
	
	public List<UserLogin> list();

	public UserLogin get(String id);

	public void saveOrUpdate(UserLogin userlogin);

	public void delete(int id);
	
	public boolean isValidUser(String id, String name);


}
