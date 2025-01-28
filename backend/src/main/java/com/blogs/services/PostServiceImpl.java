package com.blogs.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.dao.CommunityDao;
import com.blogs.dao.PostDao;
import com.blogs.dao.UserDao;
import com.blogs.dto.AddPostDto;
import com.blogs.dto.ApiResponse;
import com.blogs.dto.CommunityResponseDto;
import com.blogs.dto.PostResponseDto;
import com.blogs.pojo.Community;
import com.blogs.pojo.Post;
import com.blogs.pojo.User;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PostServiceImpl implements PostService{

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private PostDao postDao;
	
	@Autowired
	private CommunityDao communityDao;
	
	@Autowired
	private UserDao userDao;
	
/*======================= ADD POST =================================*/	
	
	@Override
	public ApiResponse addPost(AddPostDto postDto) {
		
		 Community cmnty = communityDao.findById(postDto.getCommunityId())
	                .orElseThrow(() -> new RuntimeException("Community not found"));
		 
		 User user = userDao.findById(postDto.getUserId())
	                .orElseThrow(() -> new RuntimeException("User not found"));
		
		Post post = mapper.map(postDto, Post.class);
		
		post.setCommunity(cmnty);
		post.setPostUser(user);
		
		Post p = postDao.save(post);
		
		return new ApiResponse("Post Added with post Id: "+ p.getId());
	
	}


	
/*======================= GET ALL POSTS =================================*/	
	
	@Override
	public List<PostResponseDto> getAllPosts() {
		
		 List<Post> postsList = postDao.findAll();
	     
	        List<PostResponseDto> postsResponseList = postsList.stream()
	            .map(post -> mapper.map(post, PostResponseDto.class))
	            .collect(Collectors.toList());
	        
	        return postsResponseList;
	}

	
}
