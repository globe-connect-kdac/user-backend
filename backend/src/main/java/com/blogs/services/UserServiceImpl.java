package com.blogs.services;
import com.blogs.dto.*;
import com.blogs.pojo.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.dao.UserDao;
import com.blogs.pojo.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private ModelMapper mapper;
	@Autowired
	private UserDao userDao;
	@Override
	public ApiResponse addNewUser(AddUserDto userdto) {
		User user=mapper.map(userdto, User.class);
		System.out.println(user);
		User u=userDao.save(user);
		return new ApiResponse("User is Added with user Id"+u.getId());
	}
	
	

}
