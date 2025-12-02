package org.example.instagram.service;

import java.util.List;
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

    @Override
    public PostResponse getPost(Long id) {
        return PostResponse.from(findById(id));
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
    }

    @Override
    public List<PostResponse> getAllPosts() {
        return postRepository.findAllByOrderByCreatedAtDesc().stream().map(PostResponse::from)
            .toList();
    }

}
