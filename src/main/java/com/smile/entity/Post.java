package com.smile.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
@Table(name = "post")
@Entity
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob
    private String content;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String imagePath;

    private long views;  // ์กฐํ ์

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

    public void changePost(Post post) {
        this.title = post.getTitle();
        this.content = post.getContent();
        this.category = post.getCategory();
        this.imagePath = post.getImagePath();
    }

    public void increaseViews(long views) {
        this.views = views;
    }

}
