package com.blogs.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {
    private Long userId;
    private Long postId;
    private String text;
}