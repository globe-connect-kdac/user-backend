package com.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.dto.AddCommunityDto;
import com.blogs.dto.AddUserDto;
import com.blogs.dto.CommunityResponseDto;
import com.blogs.dto.UpdateCommunityDto;
import com.blogs.dto.UpdateUserDto;
import com.blogs.pojo.Community;
import com.blogs.services.CommunityService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/community")
@CrossOrigin(origins = "*")
public class CommunityController {
	
	@Autowired
	CommunityService communityService;
	
	
	@PostMapping("add-community")
	public ResponseEntity<?> addNewCommunity(@Valid @RequestBody AddCommunityDto communityDto) {
		System.out.println(communityDto.toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(communityService.addNewCommunity(communityDto));
	}
	
	@GetMapping("/get-all")
	public ResponseEntity<?> getAllCommunities() {
		
		return ResponseEntity.status(HttpStatus.OK).body(communityService.getAllCommunities());
	}
	
	@GetMapping("/search-community")
	public ResponseEntity<?> searchCommunity(@RequestParam("title") String title) {
	    return ResponseEntity.status(HttpStatus.OK).body(communityService.findByTitle(title));
	}
	
	@PutMapping("/delete-community")
	public ResponseEntity<?> deleteCommunity(@RequestParam("userId") Long communityId) {
	 
	    return ResponseEntity.status(HttpStatus.OK).body(communityService.deleteCommunity(communityId));
	}

	@PutMapping("/update-community")
	public ResponseEntity<?> updateCommunity(@RequestParam("communityId") Long CommunityId, @RequestBody UpdateCommunityDto updateCommunityDto) {
	    return ResponseEntity.status(HttpStatus.OK).body(communityService.updateCommunity(CommunityId, updateCommunityDto));
	}

	
	
	
}
