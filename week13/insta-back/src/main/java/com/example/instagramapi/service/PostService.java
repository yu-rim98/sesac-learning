package com.example.instagramapi.service;

import com.example.instagramapi.dto.request.PostCreateRequest;
import com.example.instagramapi.dto.response.PostResponse;
import com.example.instagramapi.entity.Post;
import com.example.instagramapi.entity.User;
import com.example.instagramapi.exception.CustomException;
import com.example.instagramapi.exception.ErrorCode;
import com.example.instagramapi.repository.CommentRepository;
import com.example.instagramapi.repository.PostLikeRepository;
import com.example.instagramapi.repository.PostRepository;
import com.example.instagramapi.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PostLikeRepository postLikeRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public PostResponse create(Long userId, PostCreateRequest request) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        Post post = Post.of(request.getContent(), request.getImageUrl(), user);
        postRepository.save(post);

        return PostResponse.from(post);
    }

    // 전체 게시물
    public List<PostResponse> findAll(Long userId) {
        List<Post> posts = postRepository.findAllByWithUser();
        return posts.stream().map(post -> toPostResponseWithStats(post, userId)).toList();
    }

    // 단일 게시물
    public PostResponse findById(Long postId, Long userId) {
        Post post = postRepository.findByIdWithUser(postId)
            .orElseThrow(() -> new CustomException(ErrorCode.POST_NOT_FOUND));
        return toPostResponseWithStats(post, userId);
    }

    // 특정 사용자 게시물
    public List<PostResponse> findByUsername(String username, Long userId) {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        List<Post> posts = postRepository.findByUserIdWithUser(user.getId());
        return posts.stream().map(post -> toPostResponseWithStats(post, userId)).toList();
    }

    @Transactional
    public void delete(Long postId, Long userId) {
        Post post = postRepository.findById(postId)
            .orElseThrow(() -> new CustomException(ErrorCode.POST_NOT_FOUND));

        if (!post.isOwner(userId)) {
            throw new CustomException(ErrorCode.NOT_POST_OWNER);
        }

        postRepository.delete(post);
    }

    private PostResponse toPostResponseWithStats(Post post, Long currentUserId) {
        boolean liked =
            currentUserId != null && postLikeRepository.existsByUserIdAndPostId(currentUserId,
                post.getId());
        long likeCount = postLikeRepository.countByPostId(post.getId());
        long commentCount = commentRepository.countByPostId(post.getId());
        return PostResponse.from(post, liked, likeCount, commentCount);
    }
}
