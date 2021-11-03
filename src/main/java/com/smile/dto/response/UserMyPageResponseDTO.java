package com.smile.dto.response;

import lombok.Builder;
import lombok.Getter;

/**
 * created by Gyunny 2021/11/01
 */
@Builder
@Getter
public class UserMyPageResponseDTO {

    private final String username;
    private final Long postAllCount;
    private final Long postViewsCount;

    public static UserMyPageResponseDTO from(String username, Long postAllCount, Long postViewsCount) {
        return UserMyPageResponseDTO.builder()
                .username(username)
                .postAllCount(postAllCount)
                .postViewsCount(postViewsCount)
                .build();
    }

}
