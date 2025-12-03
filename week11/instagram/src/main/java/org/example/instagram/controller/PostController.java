package org.example.instagram.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.instagram.dto.request.CommentCreateRequest;
import org.example.instagram.dto.request.PostCreateRequest;
import org.example.instagram.security.CustomUserDetails;
import org.example.instagram.service.CommentService;
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

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final CommentService commentService;

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("postCreateRequest", new PostCreateRequest());
        return "post/form";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute PostCreateRequest request,
        BindingResult bindingResult, @AuthenticationPrincipal CustomUserDetails userDetails) {

        if (bindingResult.hasErrors()) {
            return "post/form";
        }

        postService.create(request, userDetails.getId());
        return "redirect:/";
    }

    @GetMapping("/{postId}")
    public String detail(@PathVariable Long postId, Model model) {

        model.addAttribute("post", postService.getPost(postId));
        model.addAttribute("commentCreateRequest", new CommentCreateRequest());
        return "post/detail";
    }

    @PostMapping("/{postId}/comments")
    public String createComment(@PathVariable Long postId,
        @Valid @ModelAttribute CommentCreateRequest request, BindingResult bindingResult,
        @AuthenticationPrincipal CustomUserDetails userDetails) {

        if (bindingResult.hasErrors()) {
            return "post/detail";
        }

        commentService.create(postId, request, userDetails.getId());

        return "redirect:/posts/" + postId;
    }


}
