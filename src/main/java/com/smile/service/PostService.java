package com.smile.service;

import com.smile.dto.PostResponseDTO;
import com.smile.entity.Category;
import com.smile.entity.Post;
import com.smile.entity.User;
import com.smile.error.EntityNotFoundException;
import com.smile.repository.PostRepository;
import com.smile.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

import static com.smile.entity.Post.createPost;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class PostService {

    private static final Long INCREASE_VIEWS = 1L;

    private final UserService userService;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    // 임시 코드 (나중에 삭제 예정)
    @PostConstruct
    public void init() {
        User user = userRepository.save(User.builder().email("wjdrbs966@naver.com").name("Gyunny").build());
        for (int i = 1; i <= 25; ++i) {
            postRepository.save(Post.builder().title("제목" + i).content("내용" + i).views(0L).category(Category.BOOK).user(user).build());
        }
    }

    public List<PostResponseDTO> findAllByUserOrderByIdDesc(PageRequest paging) {
        // 로그인이 되어 있다 가정이라 1번 유저가 존재한다고 가정해서 1L 로 하드코딩
        User user = userService.findOne(1L);
        return postRepository.findAllByUserOrderByIdDesc(user, paging).stream()
                .map(PostResponseDTO::from)
                .collect(Collectors.toList());
    }

    public Page<PostResponseDTO> findAll(Pageable pageable) {
        User user = userService.findOne(1L);
        return postRepository.findByUser(user, pageable)
                .map(PostResponseDTO::from);
    }

    @Transactional
    public void save(String title, String content, Category category) {
        postRepository.save(createPost(title, content, category));
    }

    @Transactional
    public void update(Long postId, String title, String content, Category category) {
        Post post = findOne(postId);
        post.changePost(title, content, category);
    }

    @Transactional
    public PostResponseDTO findOneAndIncreaseViews(Long postId) {
        Post post = findOne(postId);
        // 메소드가 두 가지 일을 같이 하는 듯
        post.increaseViews(post.getViews() + INCREASE_VIEWS);
        return PostResponseDTO.from(post);
    }

    @Transactional
    public void delete(Long postId) {
        Post post = findOne(postId);
        postRepository.delete(post);
    }

    public Post findOne(Long postId) {
        return postRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("Post is Not Exist!!"));
    }

    public List<PostResponseDTO> findSearch(String type, String keyword) {
        // 검색 type 으로 나눠야함
        User user = userService.findOne(1L);
        return postRepository.findAllByTitleContainingAndUser(keyword, user).stream()
                .map(PostResponseDTO::from)
                .collect(Collectors.toList());
    }

}
