package com.niit.musichub.service;

import java.util.List;

import com.niit.musichub.model.Users;

public interface UsersService {
	
	public List<Users> list();
	
	public Users get(int id);
	
	public void saveOrUpdate(Users users);
	
	public void delete(int id);
	
	public Users getUserByName(String username);
	
	public void addUser(Users user);

}
