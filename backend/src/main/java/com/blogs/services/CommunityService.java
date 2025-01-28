package com.blogs.services;

import com.blogs.dto.AddCommunityDto;
import com.blogs.dto.ApiResponse;

public interface CommunityService {
	
	ApiResponse addNewCommunity(AddCommunityDto community);
}
