package com.smile.service;

import com.smile.dto.response.UserMyPageResponseDTO;
import com.smile.entity.User;
import com.smile.error.EntityNotFoundException;
import com.smile.repository.PostRepository;
import com.smile.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

/**
 * created by Gyunny 2021/11/04
 */
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @DisplayName("나의 페이지 조회가 잘 되는지 테스트")
    @Test
    void userMyPageTest() {
        Long userId = 1L;
        UserMyPageResponseDTO myPage = userService.findMyPage(userId);
        User user = findUserById(userId);

        assertEquals(myPage.getUsername(), user.getName());
        assertEquals(myPage.getPostAllCount(), postRepository.countByUser(user));
        assertEquals(myPage.getPostViewsCount(), postRepository.findAllByUserViewsCount(user));
    }

    @DisplayName("유저가 존재하지 않을 때 에러 처리 테스트")
    @Test
    void userNotFoundExceptionTest() {
        assertThatThrownBy(() -> {
            userService.findOne(-1L);
        }).isInstanceOf(EntityNotFoundException.class);
    }

    private User findUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new EntityNotFoundException("Entity is not Empty!!"));
    }

}