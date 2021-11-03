package com.smile.dto.request;

import com.smile.entity.Category;
import com.smile.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.smile.entity.User.createUser;

/**
 * created by Gyunny 2021/11/03
 */
@AllArgsConstructor
@Getter
public class PostCreateRequestDTO {
    private String title;
    private String content;
    private Category category;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .category(category)
                .user(createUser())
                .build();
    }

}
