package com.blogs.dto;

import com.blogs.enums.Status;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddPostDto {

    Long userId;

    Long communityId;

    @NotEmpty(message = "Title cannot be empty")
    private String title;

    @NotEmpty(message = "Description cannot be empty")
    private String captions;

    private Status status = Status.ACTIVE;

    // New fields for handling media
    private List<String> mediaUrls;  // Stores media URLs (or file names if local storage)
}
