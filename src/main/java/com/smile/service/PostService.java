package com.smile.service;

import com.smile.dto.PostResponseDTO;
import com.smile.entity.Post;
import com.smile.entity.User;
import com.smile.error.user.UserNotFoundException;
import com.smile.repository.PostRepository;
import com.smile.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    // 임시 코드 (나중에 삭제 예정)
    @PostConstruct
    public void init() {
        User user = userRepository.save(User.builder().email("wjdrbs966@naver.com").name("Gyunny").build());
        for (int i = 0; i < 5; ++i) {
            postRepository.save(Post.builder().title("제목" + i).content("내용" + i).user(user).build());
        }
    }

    @Transactional(readOnly = true)
    public List<PostResponseDTO> getPostAllByUserId() {
        // 로그인이 되어 있다 가정이라 1번 유저가 존재한다고 가정해서 1L 로 하드코딩
        User user = userRepository.findById(1L).orElseThrow(() -> new UserNotFoundException("User Not Exist!"));
        return postRepository.findAllByUser(user).stream()
                .map(PostResponseDTO::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public void create(String title, String content) {
        Post post = Post.builder()
                .title(title)
                .content(content)
                .user(createUser())
                .build();
        postRepository.save(post);
    }

    // 1번 유저의 정보 (로그인 되어 있다고 가정 하기에 세팅)
    private User createUser() {
        return User.builder()
                .id(1L)
                .email("wjdrbs966@naver.com")
                .name("Gyunny")
                .build();
    }

}
