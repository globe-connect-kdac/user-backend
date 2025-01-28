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
		
		

		

	}



