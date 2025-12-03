package org.example.instagram.service;

import org.example.instagram.dto.request.CommentCreateRequest;
import org.example.instagram.dto.response.CommentResponse;

public interface CommentService {

    CommentResponse create(Long postId, CommentCreateRequest request, Long userId);
}
