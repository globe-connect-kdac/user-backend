package com.blogs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.dao.UserDao;
import com.blogs.pojo.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	@Override
	public String addNewUser(User user) {
		User u=userDao.save(user);
		return "User is Added with"+u.getId();
	}
	
	

}
