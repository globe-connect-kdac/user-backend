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
import com.blogs.dto.UpdateUserDto;
//import com.blogs.dto.ApiResponse;
	import com.blogs.pojo.*;
	import com.blogs.services.UserService;

import jakarta.validation.Valid;

	@RestController
	@RequestMapping("/users")
	//@CrossOrigin(origins = "http://localhost:3000")
	public class UserController {
	
		@Autowired
		private UserService userService;

		public UserController() {
			System.out.println("in ctor " + getClass());
		}
		
		@PostMapping
		public ResponseEntity<?> addNewUser(@Valid @RequestBody AddUserDto userdto) {
			System.out.println("in add user " + userdto);// transient category
			return ResponseEntity.status(HttpStatus.CREATED).body(userService.addNewUser(userdto));
		}
		
		@GetMapping
		public ResponseEntity<?> getAllUsers() {
			System.out.println("I am in getAllUsers method");
			return ResponseEntity.status(HttpStatus.FOUND).body(userService.getAllUsers());
		}
		
		@GetMapping("/searchUserByUsername")
		public ResponseEntity<?> searchUserByUsername(@RequestParam("userName") String userName) {
		    System.out.println("I am in searchUserByUsername method");
		    return ResponseEntity.status(HttpStatus.FOUND).body(userService.findUserByUsername(userName));
		}
		
		@PutMapping
		public ResponseEntity<?> deleteUserById(@RequestParam("userId") Long userId) {
		    System.out.println("I am in deleteUserById (soft delete) method");
		    return ResponseEntity.status(HttpStatus.FOUND).body(userService.deleteUserById(userId));
		}


		@PutMapping("/updateUser")
		public ResponseEntity<?> updateUser(@RequestParam("userId") Long userId, @RequestBody UpdateUserDto updateUserDto) {
			 System.out.println("I am in updateUser  method");
//			ApiResponse response = userService.updateUser(userId, updateUserDto);
		    return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(userId, updateUserDto));
		}


	}



