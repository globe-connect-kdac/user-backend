package com.blogs.services;

import java.util.List;

import com.blogs.dto.AddCommunityDto;
import com.blogs.dto.ApiResponse;
import com.blogs.dto.CommunityResponseDto;
import com.blogs.dto.UpdateCommunityDto;
import com.blogs.pojo.Community;

public interface CommunityService {
	
	ApiResponse addNewCommunity(AddCommunityDto community);

	List<CommunityResponseDto> getAllCommunities();

	CommunityResponseDto findByTitle(String title);

	ApiResponse deleteCommunity(Long communityId);

	ApiResponse updateCommunity(Long communityId, UpdateCommunityDto updateCommunityDto);

}
