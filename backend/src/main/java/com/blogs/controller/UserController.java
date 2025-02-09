package com.blogs.controller;
import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.ResponseBody;
	import org.springframework.web.bind.annotation.RestController;

import com.blogs.dto.AddUserDto;
import com.blogs.dto.ApiResponse;
import com.blogs.dto.LoginDto;
import com.blogs.dto.UpdateUserDto;
//import com.blogs.dto.ApiResponse;
	import com.blogs.pojo.*;
	import com.blogs.services.UserService;

import jakarta.validation.Valid;

	@RestController
	@RequestMapping("/users")
	@CrossOrigin(origins = "*")
	public class UserController {
	
		@Autowired
		private UserService userService;

		public UserController() {
			System.out.println("in ctor " + getClass());
		}
		
		@PostMapping("add-user")
		public ResponseEntity<?> addNewUser(@Valid @RequestBody AddUserDto userdto) {
			System.out.println("in add user " + userdto);// transient category
			return ResponseEntity.status(HttpStatus.CREATED).body(userService.addNewUser(userdto));
		}
		
		@GetMapping("/get-all")
		public ResponseEntity<?> getAllUsers() {
			System.out.println("I am in getAllUsers method");
			return ResponseEntity.status(HttpStatus.FOUND).body(userService.getAllUsers());
		}
		
		@GetMapping("/search-user")
		public ResponseEntity<?> searchUserByUsername(@RequestParam("userName") String userName) {
		    System.out.println("I am in searchUserByUsername method");
		    return ResponseEntity.status(HttpStatus.FOUND).body(userService.findUserByUsername(userName));
		}
		
		@PutMapping("/delete-user")
		public ResponseEntity<?> deleteUserById(@RequestParam("userId") Long userId) {
		    System.out.println("I am in deleteUserById (soft delete) method");
		    return ResponseEntity.status(HttpStatus.FOUND).body(userService.deleteUserById(userId));
		}


		@PutMapping("/update-user")
		public ResponseEntity<?> updateUser(@RequestParam("userId") Long userId, @RequestBody UpdateUserDto updateUserDto) {
			 System.out.println("I am in updateUser  method");
//			ApiResponse response = userService.updateUser(userId, updateUserDto);
		    return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(userId, updateUserDto));
		}

		
		@PostMapping("/login")
		public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) {
		    System.out.println("User Login Attempt: " + loginDto.getEmail());
		    ApiResponse response = userService.loginUser(loginDto);
		    
		    if (response.getMessage().equals("Login Successful")) {
		        return ResponseEntity.ok(response);
		    } else {
		        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
		    }
		}

		
		
		
	}



