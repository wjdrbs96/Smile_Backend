package com.smile.repository;

import com.smile.entity.Post;
import com.smile.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findByUser(User user, Pageable pageable);

    Long countByUser(User user);

    @Query("SELECT SUM(p.views) FROM Post p WHERE p.user =:user")
    Long findAllByUserViewsCount(User user);

    List<Post> findAllByTitleContainingAndUser(String title, User user);

}
