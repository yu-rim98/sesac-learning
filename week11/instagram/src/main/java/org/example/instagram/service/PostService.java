package org.example.instagram.service;

import org.example.instagram.dto.request.PostCreateRequest;
import org.example.instagram.dto.response.PostResponse;

public interface PostService {

    PostResponse create(PostCreateRequest request, Long userId);
}
