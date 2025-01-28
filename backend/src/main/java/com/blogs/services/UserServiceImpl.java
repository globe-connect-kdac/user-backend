package com.blogs.services;
import com.blogs.dto.*;
import com.blogs.enums.Status;
import com.blogs.pojo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
/*=================== ADD USER ====================*/
	
	@Override
	public ApiResponse addNewUser(AddUserDto userdto) {
		User user=mapper.map(userdto, User.class);
		System.out.println(user);
		User u=userDao.save(user);
		return new ApiResponse("User is Added with user Id"+u.getId());
	}

/*=================== GET ALL USERS ====================*/
	
	@Override
	public List<User> getAllUsers() {
		
		List<User> usersList = userDao.findAll();
		
		for (User user : usersList) {
			System.out.println(user.toString());
		}
		
		return usersList;
	}

/*=================== FIND USER BY USER_NAME====================*/
	
	@Override
	public User findUserByUsername(String userName) {
		
		List<User> usersList = userDao.findAll();
		User user;
		for (User u : usersList) {
			System.out.println(u.getUserName());
			if(u.getUserName().equals(userName))
			{
				return u;
			}
		}
		
		return null;
	}

/*=================== DELETE USER BY ID ====================*/
	
	@Override
	public ApiResponse deleteUserById(Long userId) {
	    
		// Optional because it'll avoid null pointer exception in case user not found
	    Optional<User> optionalUser = userDao.findById(userId);
	    
	    if (optionalUser.isPresent()) {
	        User user = optionalUser.get();
	        user.setStatus(Status.INACTIVE); 
	     
	        userDao.save(user);
	        
	        return new ApiResponse("User deleted successfully...!!!" + userId);
	    } else {
	        return new ApiResponse("User not found...!!!" + userId);
	    }
	}

	/*=================== DELETE USER BY ID ====================*/

	
	
	
	

}
