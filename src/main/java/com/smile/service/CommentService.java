package com.smile.service;

import com.smile.dto.PostCommentResponseDTO;
import com.smile.entity.Comment;
import com.smile.entity.Post;
import com.smile.error.EntityNotFoundException;
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

    @Transactional
    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new EntityNotFoundException("Comment is Not Exist"));
        commentRepository.delete(comment);
    }

    private Post findOne(Long postId) {
        return postRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("Post is Not Exist"));
    }

}
