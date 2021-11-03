package com.smile.service;

import com.smile.entity.Category;
import com.smile.entity.Comment;
import com.smile.entity.Post;
import com.smile.entity.User;
import com.smile.error.EntityNotFoundException;
import com.smile.repository.CommentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static com.smile.entity.Comment.createComment;
import static com.smile.entity.User.createUser;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

/**
 * created by Gyunny 2021/11/04
 */
@Transactional
@SpringBootTest
class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentRepository commentRepository;

    @DisplayName("댓글 작성이 잘 되는지 테스트")
    @Test
    void saveCommentTest() {
        Comment saveComment = commentRepository.save(createComment(createPost(), "댓글"));
        Comment findComment = commentRepository.findById(saveComment.getId()).orElseThrow(() -> new EntityNotFoundException("Entity is not Empty!!"));

        assertEquals(saveComment.getComment(), findComment.getComment());
        assertEquals(saveComment.getId(), findComment.getId());
    }

    @DisplayName("댓글이 잘 삭제 되는지 테스트")
    @Test
    void deleteCommentTest() {
        Comment saveComment = commentRepository.save(createComment(createPost(), "댓글"));
        commentRepository.delete(saveComment);

        assertThatThrownBy(() -> {
            commentRepository.findById(saveComment.getId()).orElseThrow(() -> new EntityNotFoundException("Entity is Not Empty!!"));
        }).isInstanceOf(EntityNotFoundException.class);
    }

    private Post createPost() {
        return Post.builder()
                .title("제목")
                .content("내용")
                .category(Category.LIFE)
                .user(createUser())
                .build();
    }

}