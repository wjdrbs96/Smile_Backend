package com.smile.repository;

import com.smile.entity.Comment;
import com.smile.entity.Post;
import com.smile.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPostAndUser(Post post, User user);

}
