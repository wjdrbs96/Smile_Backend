package com.smile.dto;

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
    private LocalDateTime createdTime;
    private LocalDateTime lastModifiedTime;

    public static PostResponseDTO from(Post post) {
        return PostResponseDTO.builder()
                .id(post.getId())
                .username(post.getUser().getName())
                .title(post.getTitle())
                .content(post.getContent())
                .createdTime(post.getCreatedTime())
                .lastModifiedTime(post.getLastModifiedTime())
                .build();
    }

}
