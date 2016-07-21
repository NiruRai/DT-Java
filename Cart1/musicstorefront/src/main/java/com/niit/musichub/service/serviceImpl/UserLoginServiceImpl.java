package com.niit.musichub.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.musichub.dao.UserLoginDao;
import com.niit.musichub.model.UserLogin;
import com.niit.musichub.service.UserLoginService;

@Service
public class UserLoginServiceImpl implements UserLoginService {
	
	@Autowired
	UserLoginDao userLoginDao;

	public List<UserLogin> list() {
		
		return userLoginDao.list();
	}

	public UserLogin get(String id) {
		
		return userLoginDao.get(id);
	}

	public void saveOrUpdate(UserLogin userlogin) {

		userLoginDao.saveOrUpdate(userlogin);
		
	}

	public void delete(int id) {

		userLoginDao.delete(id);
		
	}

	public boolean isValidUser(String name, String password) {
		
		return userLoginDao.isValidUser(name, password);
	}

}
