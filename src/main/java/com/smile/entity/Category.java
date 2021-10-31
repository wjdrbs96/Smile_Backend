package com.smile.entity;

import lombok.Getter;

@Getter
public enum Category {
    BOOK("독서"),
    LIFE("일상"),
    STUDY("공부"),
    TRAVEL("여행");

    private final String categoryKorean;

    Category(String categoryKorean) {
        this.categoryKorean = categoryKorean;
    }

}
