package com.smile.dto.response;

import com.smile.entity.Comment;
import com.smile.entity.Post;
import lombok.Builder;
import lombok.Getter;

import static com.smile.util.LocalDateTimeToStringUtil.localDateTimeToStringConverter;

@Builder
@Getter
public class PostCommentResponseDTO {

    private Long postId;
    private Long commentId;
    private String username;
    private String content;
    private String createdTime;

    public static PostCommentResponseDTO from(Comment comment) {
        Post post = comment.getPost();
        return PostCommentResponseDTO.builder()
                .postId(post.getId())
                .commentId(comment.getId())
                .username(comment.getUser().getName())
                .content(comment.getComment())
                .createdTime(localDateTimeToStringConverter(comment.getCreatedTime()))
                .build();
    }

}
