package com.smile.service;

import com.smile.dto.PostCommentResponseDTO;
import com.smile.entity.Comment;
import com.smile.entity.Post;
import com.smile.error.EntityNotFoundException;
import com.smile.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

import static com.smile.entity.Comment.createComment;
import static com.smile.entity.User.createUser;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final PostService postService;
    private final CommentRepository commentRepository;

    @Transactional(readOnly = true)
    public List<PostCommentResponseDTO> findAll(Long postId) {
        Post post = postService.findOne(postId);
        return commentRepository.findByPostAndUser(post, createUser()).stream()
                .map(PostCommentResponseDTO::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public void save(Long postId, String content) {
        Post post = postService.findOne(postId);
        commentRepository.save(createComment(post, content));
    }

    @Transactional
    public void delete(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new EntityNotFoundException("Comment is Not Exist"));
        commentRepository.delete(comment);
    }

}
