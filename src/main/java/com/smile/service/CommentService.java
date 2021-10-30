package com.smile.service;

import com.smile.dto.PostCommentResponseDTO;
import com.smile.entity.Post;
import com.smile.error.post.PostNotFoundException;
import com.smile.repository.CommentRepository;
import com.smile.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.smile.entity.Comment.createComment;
import static com.smile.entity.User.createUser;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<PostCommentResponseDTO> findComment(Long postId) {
        Post post = findOne(postId);
        return commentRepository.findByPostAndUser(post, createUser()).stream()
                .map(PostCommentResponseDTO::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public void save(Long postId, String content) {
        Post post = findOne(postId);
        commentRepository.save(createComment(post, content));
    }

    public Post findOne(Long postId) {
        return postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException("Post is Not Exist"));
    }

}
