package com.smile.service;

import com.smile.dto.UserMyPageResponseDTO;
import com.smile.entity.User;
import com.smile.error.EntityNotFoundException;
import com.smile.repository.PostRepository;
import com.smile.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public UserMyPageResponseDTO findMyPage() {
        User user = userRepository.findById(1L).orElseThrow(() -> new EntityNotFoundException("User is Not Exist!!"));
        return UserMyPageResponseDTO.from(user.getName(), postRepository.findAllByUserPostCount(user), postRepository.findAllByUserViewsCount(user));
    }

}
