package com.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.dto.AddCommunityDto;
import com.blogs.dto.AddPostDto;
import com.blogs.services.PostService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	PostService postService;
	
	@PostMapping("/add-post")
	public ResponseEntity<?> addPost(@Valid @RequestBody AddPostDto postDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(postService.addPost(postDto));
	}
	
	
	
}
