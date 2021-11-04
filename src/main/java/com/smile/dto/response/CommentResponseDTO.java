package com.smile.dto.response;

import com.smile.entity.Comment;
import lombok.Builder;
import lombok.Getter;

/**
 * created by Gyunny 2021/11/04
 */
@Builder
@Getter
public class CommentResponseDTO {
    private Long commentId;
    private String content;

    public static CommentResponseDTO from(Comment comment) {
        return CommentResponseDTO.builder()
                .commentId(comment.getId())
                .content(comment.getComment())
                .build();
    }

}
