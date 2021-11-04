package com.smile.dto.response;

import com.smile.entity.Category;
import com.smile.entity.Post;
import lombok.Builder;
import lombok.Getter;

import static com.smile.util.LocalDateTimeToStringUtil.localDateTimeToStringConverter;

@Builder
@Getter
public class PostResponseDTO {

    private Long id;
    private String username;
    private String title;
    private String content;
    private Category category;
    private String imagePath;
    private Long views;

    private String createdTime;

    private String lastModifiedTime;

    public static PostResponseDTO from(Post post) {
        return PostResponseDTO.builder()
                .id(post.getId())
                .username(post.getUser().getName())
                .title(post.getTitle())
                .content(post.getContent())
                .category(post.getCategory())
                .imagePath(post.getImagePath())
                .views(post.getViews())
                .createdTime(localDateTimeToStringConverter(post.getCreatedTime()))
                .lastModifiedTime(localDateTimeToStringConverter(post.getLastModifiedTime()))
                .build();
    }

}
