package org.example.instagram.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.instagram.dto.request.CommentRequest;
import org.example.instagram.dto.request.PostCreateRequest;
import org.example.instagram.security.CustomUserDetails;
import org.example.instagram.service.CommentService;
import org.example.instagram.service.LikeService;
import org.example.instagram.service.PostService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final CommentService commentService;
    private final LikeService likeService;

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("postCreateRequest", new PostCreateRequest());
        return "post/form";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute PostCreateRequest request,
        @RequestParam(required = false, value = "image") MultipartFile image,
        BindingResult bindingResult, @AuthenticationPrincipal CustomUserDetails userDetails) {

        if (bindingResult.hasErrors()) {
            return "post/form";
        }

        postService.create(request, image, userDetails.getId());
        return "redirect:/";
    }

    @GetMapping("/{postId}")
    public String detail(@PathVariable Long postId, Model model,
        @AuthenticationPrincipal CustomUserDetails userDetails) {

        model.addAttribute("post", postService.getPost(postId));
        model.addAttribute("commentRequest", new CommentRequest());
        model.addAttribute("comments", commentService.getCommentsByPostId(postId));
        model.addAttribute("liked", likeService.isLiked(postId, userDetails.getId()));
        model.addAttribute("likeCount", likeService.getLikeCount(postId));

        return "post/detail";
    }

    @PostMapping("/{postId}/comments")
    public String createComment(@PathVariable Long postId,
        @Valid @ModelAttribute CommentRequest request, BindingResult bindingResult,
        @AuthenticationPrincipal CustomUserDetails userDetails, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("post", postService.getPost(postId));
            model.addAttribute("comments", commentService.getCommentsByPostId(postId));
            model.addAttribute("liked", likeService.isLiked(postId, userDetails.getId()));
            model.addAttribute("likeCount", likeService.getLikeCount(postId));

            return "post/detail";
        }

        commentService.create(postId, request, userDetails.getId());

        return "redirect:/posts/" + postId;
    }

    @PostMapping("/{postId}/like")
    public String toggleLike(@PathVariable Long postId,
        @AuthenticationPrincipal CustomUserDetails userDetails) {
        likeService.toggleLike(postId, userDetails.getId());
        return "redirect:/posts/" + postId;
    }


}
