package com.smile.service;

import com.smile.dto.request.PostSaveRequestDTO;
import com.smile.dto.request.PostUpdateRequestDTO;
import com.smile.dto.response.PostResponseDTO;
import com.smile.entity.Category;
import com.smile.entity.Post;
import com.smile.error.EntityNotFoundException;
import com.smile.repository.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * created by Gyunny 2021/11/04
 */
@Transactional
@SpringBootTest
class PostServiceTest {

    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @DisplayName("게시글 저장이 잘 되는지 테스트")
    @Test
    void savePostTest() {
        PostSaveRequestDTO postSaveRequestDTO = new PostSaveRequestDTO("제목", "내용", Category.BOOK);
        Post savePost = postRepository.save(postSaveRequestDTO.toEntity());
        Post findPost = postRepository.findById(savePost.getId()).orElseThrow(() -> new EntityNotFoundException("Entity is Not Empty!!"));

        assertEquals(savePost.getTitle(), findPost.getTitle());
        assertEquals(savePost.getContent(), findPost.getContent());
        assertEquals(savePost.getCategory(), findPost.getCategory());
    }

    @DisplayName("게시글 클릭할 때마다 조회 수가 1 증가하는 지 테스트")
    @Test
    void increasePostViewsTest() {
        Post post = findPost(1L);
        PostResponseDTO dto = postService.findOneAndIncreaseViews(post.getId());
        assertEquals(post.getViews(), dto.getViews());
    }

    @DisplayName("게시글 삭제가 잘 되는지 테스트")
    @Test
    void deletePostTest() {
        Long postId = 1L;
        postService.delete(postId);
        assertThatThrownBy(() -> {
            postRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("Entity is not Empty!!"));
        }).isInstanceOf(EntityNotFoundException.class);
    }

    @DisplayName("게시글 수정이 잘 되는지 테스트")
    @Test
    void updatePostTest() {
        PostUpdateRequestDTO dto = new PostUpdateRequestDTO(1L, "제목", "내용", Category.STUDY);
        postService.update(dto);

        Post post = findPost(1L);

        assertEquals(dto.getTitle(), post.getTitle());
        assertEquals(dto.getContent(), post.getContent());
        assertEquals(dto.getCategory(), post.getCategory());
    }

    private Post findPost(Long postId) {
        return postRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("Entity is not Empty!!"));
    }

}