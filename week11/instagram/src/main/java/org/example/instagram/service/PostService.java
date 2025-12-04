package org.example.instagram.service;

import java.util.List;
import org.example.instagram.dto.request.PostCreateRequest;
import org.example.instagram.dto.response.PostResponse;
import org.example.instagram.entity.Post;
import org.springframework.web.multipart.MultipartFile;

public interface PostService {

    PostResponse create(PostCreateRequest request, MultipartFile image, Long userId);

    PostResponse getPost(Long postId);

    Post findById(Long id);

    List<PostResponse> getAllPosts();

    List<PostResponse> getPostsByUsername(String username);

    long countByUserId(Long userId);

    List<PostResponse> getAllPostsWithStats();
}
