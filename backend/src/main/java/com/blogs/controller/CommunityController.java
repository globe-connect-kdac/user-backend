package com.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.dto.AddCommunityDto;
import com.blogs.dto.AddUserDto;
import com.blogs.dto.CommunityResponseDto;
import com.blogs.pojo.Community;
import com.blogs.services.CommunityService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/community")
public class CommunityController {
	
	@Autowired
	CommunityService communityService;
	
	
	@PostMapping
	public ResponseEntity<?> addNewCommunity(@Valid @RequestBody AddCommunityDto communityDto) {
		System.out.println(communityDto.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(communityService.addNewCommunity(communityDto));
	}
	
	@GetMapping
	public ResponseEntity<?> getAllCommunities() {
		
		return ResponseEntity.status(HttpStatus.FOUND).body(communityService.getAllCommunities());
	}
	
	@GetMapping("/search-community")
	public ResponseEntity<?> searchCommunity(@RequestParam("title") String title) {
	    return ResponseEntity.status(HttpStatus.FOUND).body(communityService.findByTitle(title));
	}
	
	
	
	
}
