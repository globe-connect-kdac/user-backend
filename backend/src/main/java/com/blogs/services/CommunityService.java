package com.blogs.services;

import java.util.List;

import com.blogs.dto.AddCommunityDto;
import com.blogs.dto.ApiResponse;
import com.blogs.dto.CommunityResponseDto;
import com.blogs.pojo.Community;

public interface CommunityService {
	
	ApiResponse addNewCommunity(AddCommunityDto community);

	List<CommunityResponseDto> getAllCommunities();

	CommunityResponseDto findByTitle(String title);

}
