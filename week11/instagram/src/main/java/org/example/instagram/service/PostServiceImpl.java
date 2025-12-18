package org.example.instagram.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.instagram.dto.request.PostCreateRequest;
import org.example.instagram.dto.response.PostResponse;
import org.example.instagram.entity.Post;
import org.example.instagram.entity.User;
import org.example.instagram.exception.BusinessException;
import org.example.instagram.exception.ErrorCode;
import org.example.instagram.repository.CommentRepository;
import org.example.instagram.repository.FollowRepository;
import org.example.instagram.repository.LikeRepository;
import org.example.instagram.repository.PostRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
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
    private final FollowRepository followRepository;

    @Override
    @Transactional
    public PostResponse create(PostCreateRequest createRequest, MultipartFile image, Long userId) {
        User user = userService.findById(userId);
        String imageUrl = fileService.upload(image);

        Post post = Post.builder()
            .content(createRequest.getContent())
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
            .orElseThrow(() -> new BusinessException(ErrorCode.POST_NOT_FOUND));
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
            .map(this::toResponse).toList();
    }

    @Override
    public Slice<PostResponse> getFeedPosts(Long userId, Pageable pageable) {
        List<Long> followingIds = followRepository.findFollowingIdsByFollowerId(userId);

        Slice<Post> posts = postRepository.findFeedPostsByUserIds(followingIds, pageable);
        List<PostResponse> content = posts.stream()
            .map(this::toResponse).toList();
        return new SliceImpl<>(content, pageable, posts.hasNext());
    }

    @Override
    public Slice<PostResponse> getAllPostsPaging(Pageable pageable) {
        Slice<Post> posts = postRepository.findAllWithUserPaging(pageable);
        List<PostResponse> content = posts.stream()
            .map(this::toResponse).toList();
        return new SliceImpl<>(content, pageable, posts.hasNext());
    }

    @Override
    public Slice<PostResponse> searchPosts(String keyword, Pageable pageable) {
        Slice<Post> posts =  postRepository.searchByKeyword(keyword, pageable);
        List<PostResponse> content = posts.stream()
            .map(this::toResponse).toList();
        return new SliceImpl<>(content, pageable, posts.hasNext());
    }

    private PostResponse toResponse(Post post) {
        long likeCount = likeRepository.countByPostId(post.getId());
        long commentCount = commentRepository.countByPostId(post.getId());
        return PostResponse.from(post, commentCount, likeCount);
    }


}
