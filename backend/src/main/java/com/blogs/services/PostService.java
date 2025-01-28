package com.blogs.services;

import com.blogs.dto.AddPostDto;
import com.blogs.dto.ApiResponse;


public interface PostService {

	ApiResponse addPost(AddPostDto postDto);

}
