package org.example.instagram.service;

import lombok.RequiredArgsConstructor;
import org.example.instagram.dto.request.PostCreateRequest;
import org.example.instagram.dto.response.PostResponse;
import org.example.instagram.entity.Post;
import org.example.instagram.entity.User;
import org.example.instagram.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostServiceImpl implements PostService {

    private final UserService userService;
    private final PostRepository postRepository;

    @Override
    @Transactional
    public PostResponse create(PostCreateRequest request, Long userId) {
        User user = userService.findById(userId);

        Post post = Post.builder()
            .content(request.getContent())
            .user(user)
            .build();

        return PostResponse.from(postRepository.save(post));
    }
}
