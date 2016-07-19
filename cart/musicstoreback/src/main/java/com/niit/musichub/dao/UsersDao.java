package com.niit.musichub.dao;

import java.util.List;
import com.niit.musichub.model.Users;

public interface UsersDao {
	
	public List<Users> list();
	
	public Users get(int id);
	
	public void saveOrUpdate(Users users);
	
	public void delete(int id);
	
	public Users getUserByName(String username);

}
