package com.blogs.services;

import java.util.List;

import com.blogs.dto.AddPostDto;
import com.blogs.dto.ApiResponse;
import com.blogs.dto.PostResponseDto;


public interface PostService {

	ApiResponse addPost(AddPostDto postDto);

	List<PostResponseDto> getAllPosts();

}
