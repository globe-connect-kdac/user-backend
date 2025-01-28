package com.blogs.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class PostServiceImpl implements PostService{

	@Autowired
	private ModelMapper mapper;
	
	
}
