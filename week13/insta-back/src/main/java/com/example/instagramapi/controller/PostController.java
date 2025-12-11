package com.example.instagramapi.controller;

import com.example.instagramapi.dto.request.PostCreateRequest;
import com.example.instagramapi.dto.response.ApiResponse;
import com.example.instagramapi.dto.response.LikeResponse;
import com.example.instagramapi.dto.response.PostResponse;
import com.example.instagramapi.security.CustomUserDetails;
import com.example.instagramapi.service.PostLikeService;
import com.example.instagramapi.service.PostService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final PostLikeService postLikeService;


    @PostMapping
    public ResponseEntity<ApiResponse<PostResponse>> create(
        @AuthenticationPrincipal CustomUserDetails userDetails,
        @Valid @RequestBody PostCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(ApiResponse.success(postService.create(userDetails.getId(), request)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PostResponse>>> findAll(
        @AuthenticationPrincipal CustomUserDetails userDetails) {
        Long userId = getUserId(userDetails);
        return ResponseEntity.ok(ApiResponse.success(postService.findAll(userId)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PostResponse>> findById(@PathVariable Long id,
        @AuthenticationPrincipal CustomUserDetails userDetails) {
        Long userId = getUserId(userDetails);
        return ResponseEntity.ok(ApiResponse.success(postService.findById(id, userId)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id,
        @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        postService.delete(id, customUserDetails.getId());
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/like")
    public ResponseEntity<ApiResponse<LikeResponse>> like(@PathVariable Long id,
        @AuthenticationPrincipal CustomUserDetails userDetails) {
        return ResponseEntity.ok(
            ApiResponse.success(postLikeService.like(userDetails.getId(), id)));
    }

    @DeleteMapping("/{id}/like")
    public ResponseEntity<ApiResponse<LikeResponse>> unlike(@PathVariable Long id,
        @AuthenticationPrincipal CustomUserDetails userDetails) {
        return ResponseEntity.ok(
            ApiResponse.success(postLikeService.unlike(userDetails.getId(), id)));
    }

    @GetMapping("/{id}/like")
    public ResponseEntity<ApiResponse<LikeResponse>> getLikeStatus(@PathVariable Long id,
        @AuthenticationPrincipal CustomUserDetails userDetails) {
        Long userId = userDetails != null ? userDetails.getId() : null;
        return ResponseEntity.ok(ApiResponse.success(postLikeService.getLikeStatus(userId, id)));

    }

    private Long getUserId(CustomUserDetails userDetails) {
        return userDetails != null ? userDetails.getId() : null;
    }

}
