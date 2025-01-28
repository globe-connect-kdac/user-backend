package com.blogs.services;
import java.util.List;

import com.blogs.dto.*;
import com.blogs.pojo.User;

public interface UserService {

	ApiResponse addNewUser(AddUserDto user);
	
	List<User> getAllUsers();
	
	User findUserByUsername(String userName);

	ApiResponse deleteUserById(Long userId);
	
	ApiResponse updateUser(Long userId, UpdateUserDto updateUserDto);

}
