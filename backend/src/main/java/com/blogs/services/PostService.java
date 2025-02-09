package com.blogs.services;

import java.util.List;

import com.blogs.dto.AddPostDto;
import com.blogs.dto.ApiResponse;
import com.blogs.dto.PostResponseDto;
import com.blogs.dto.UpdatePostDto;


public interface PostService {

	ApiResponse addPost(AddPostDto postDto);

	List<PostResponseDto> getAllPosts();

	ApiResponse deletePost(Long postId);

	ApiResponse updatePost(Long postId, UpdatePostDto updatePostDto);

}
