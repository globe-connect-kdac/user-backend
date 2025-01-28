package com.blogs.dto;

import com.blogs.enums.Category;
import com.blogs.enums.Status;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommunityResponseDto {

    private String title;
    private String description;
    private Status status;
    private Category category;
    private Long ownerId;

}
