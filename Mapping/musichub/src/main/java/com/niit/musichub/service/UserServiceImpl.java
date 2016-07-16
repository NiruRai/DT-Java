package com.niit.musichub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.musichub.dao.UserLoginDao;
import com.niit.musichub.model.UserLogin;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserLoginDao udo;
	
	public List<UserLogin> list() {
		
		return udo.list();
	}

	public UserLogin get(String id) {
		
		return udo.get(id);
	}

	public void saveOrUpdate(UserLogin userlogin) {
		
		udo.saveOrUpdate(userlogin);
		
	}

	public void delete(int id) {

		udo.delete(id);
		
	}

	public boolean isValidUser(String id, String name) {
		
		return udo.isValidUser(id, name);
	}

}
