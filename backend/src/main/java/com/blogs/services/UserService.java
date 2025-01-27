package com.blogs.services;
import com.blogs.dto.*;
import com.blogs.pojo.User;

public interface UserService {

	ApiResponse addNewUser(AddUserDto user);

}
