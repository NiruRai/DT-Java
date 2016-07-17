package com.niit.musichub.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.musichub.dao.UsersDao;
import com.niit.musichub.model.Users;
import com.niit.musichub.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	UsersDao udo;

	public List<Users> list() {
		
		return udo.list();
	}

	public Users get(int id) {
		
		return udo.get(id);
	}

	public void saveOrUpdate(Users users) {

		udo.saveOrUpdate(users);
		
	}

	public void delete(int id) {

		udo.delete(id);
		
	}

	public Users getUserByName(String username) {
		
		return udo.getUserByName(username);
	}

}
