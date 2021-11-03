package com.smile.dto.request;

import com.smile.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * created by Gyunny 2021/11/03
 */
@AllArgsConstructor
@Getter
public class PostUpdateRequestDTO {
    private Long postId;
    private String title;
    private String content;
    private Category category;

}
