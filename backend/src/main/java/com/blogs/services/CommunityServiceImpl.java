package com.blogs.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.dao.CommunityDao;
import com.blogs.dao.UserDao;
import com.blogs.dto.AddCommunityDto;
import com.blogs.dto.ApiResponse;
import com.blogs.pojo.Community;
import com.blogs.pojo.User;

@Service
@Transactional
public class CommunityServiceImpl implements CommunityService{

    @Autowired
    private ModelMapper mapper;
    
    @Autowired
    private CommunityDao communityDao;
    
    @Autowired
    private UserDao userDao;
    
    @Override
    public ApiResponse addNewCommunity(AddCommunityDto communityDto) {
        
        // Retrieve the owner User object using the ownerId
        User owner = userDao.findById(communityDto.getOwnerId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Map the DTO to Community entity
        Community community = mapper.map(communityDto, Community.class);

        // Set the owner of the community
        community.setOwner(owner);

        // Save the community to the database
        Community cmnty = communityDao.save(community);

        // Return the response
        return new ApiResponse("Community added successfully...!!! With ID: " + cmnty.getId());
    }
}
