package com.smile.dto;

import com.smile.entity.Category;
import com.smile.entity.Post;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class PostResponseDTO {

    private Long id;
    private String username;
    private String title;
    private String content;
    private Category category;
    private Long views;
    private LocalDateTime createdTime;
    private LocalDateTime lastModifiedTime;

    public static PostResponseDTO from(Post post) {
        return PostResponseDTO.builder()
                .id(post.getId())
                .username(post.getUser().getName())
                .title(post.getTitle())
                .content(post.getContent())
                .category(post.getCategory())
                .views(post.getViews())
                .createdTime(post.getCreatedTime())
                .lastModifiedTime(post.getLastModifiedTime())
                .build();
    }

}
