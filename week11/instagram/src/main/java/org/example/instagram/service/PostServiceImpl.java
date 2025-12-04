package org.example.instagram.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.instagram.dto.request.PostCreateRequest;
import org.example.instagram.dto.response.PostResponse;
import org.example.instagram.entity.Post;
import org.example.instagram.entity.User;
import org.example.instagram.repository.CommentRepository;
import org.example.instagram.repository.LikeRepository;
import org.example.instagram.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostServiceImpl implements PostService {

    private final UserService userService;
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;
    private final CommentRepository commentRepository;
    private final FileService fileService;

    @Override
    @Transactional
    public PostResponse create(PostCreateRequest request, MultipartFile image, Long userId) {
        User user = userService.findById(userId);
        String imageUrl = fileService.upload(image);

        Post post = Post.builder()
            .content(request.getContent())
            .user(user)
            .imageUrl(imageUrl)
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

    @Override
    public List<PostResponse> getPostsByUsername(String username) {
        User user = userService.findByUsername(username);
        return postRepository.findByUserIdOrderByCreatedAtDesc(user.getId()).stream()
            .map(PostResponse::from).toList();
    }

    @Override
    public long countByUserId(Long userId) {
        return postRepository.countByUserId(userId);
    }

    @Override
    public List<PostResponse> getAllPostsWithStats() {
        return postRepository.findAllByOrderByCreatedAtDesc().stream()
            .map(post -> {
                long likeCount = likeRepository.countByPostId(post.getId());
                long commentCount = commentRepository.countByPostId(post.getId());
                return PostResponse.from(post, commentCount, likeCount);
            }).toList();
    }

}
