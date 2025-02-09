package com.blogs.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ApiResponse {
	private String message;
	private LocalDateTime timeStamp;
	private String string;
	private Long id;
	private String userName;
	public ApiResponse(String message) {
		super();
		this.message = message;
		this.timeStamp=LocalDateTime.now();
	}
	public ApiResponse(String message, Long id, String userName) 
	{
	    this.message = message; 
	    this.id = id;
	    this.userName = userName;
	}
	
	
}
