package com.smile.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Paging {

    private final int page;
    private final int pageSize;        // 한 페이지당 게시글 수
    private final long pageButtonSize;  // 총 페이지 버튼 수

    public static Paging createPaging(int page, int pageSize, long pageButtonSize) {
        return Paging.builder()
                .page((page - 1) * pageSize)
                .pageSize(pageSize)
                .pageButtonSize(pageButtonSize)
                .build();
    }

}
