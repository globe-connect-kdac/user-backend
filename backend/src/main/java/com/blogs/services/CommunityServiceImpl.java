package com.blogs.services;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogs.dao.CommunityDao;
import com.blogs.dao.UserDao;
import com.blogs.dto.AddCommunityDto;
import com.blogs.dto.ApiResponse;
import com.blogs.dto.CommunityResponseDto;
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
    
    
/*================== ADD COMMUNITY =======================*/
    @Override
    public ApiResponse addNewCommunity(AddCommunityDto communityDto) {
        
        User owner = userDao.findById(communityDto.getOwnerId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Community community = mapper.map(communityDto, Community.class);

        community.setOwner(owner);

        Community cmnty = communityDao.save(community);

        return new ApiResponse("Community added successfully...!!! With ID: " + cmnty.getId());
    }

/*================== GET ALL COMMUNITIES =======================*/
	
    @Override
    public List<CommunityResponseDto> getAllCommunities() {

        List<Community> communityList = communityDao.findAll();
        
        List<CommunityResponseDto> cmntyResponseList = communityList.stream()
            .map(community -> mapper.map(community, CommunityResponseDto.class))
            .collect(Collectors.toList());
        
        return cmntyResponseList;
    }

/*================ GET COMMUNITY BY TITLE ================= */

	@Override
	public CommunityResponseDto findByTitle(String title) {
		
		List<Community> cmntyList = communityDao.findAll();
		
		for (Community community : cmntyList) {
			
			if(community.getTitle().equals(title))
			{
				return mapper.map(community, CommunityResponseDto.class);
			}
		}
		
		return null;
	}

    
	
}
