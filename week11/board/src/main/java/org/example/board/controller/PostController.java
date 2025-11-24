package org.example.board.controller;

import lombok.RequiredArgsConstructor;
import org.example.board.dto.PostDto;
import org.example.board.entity.Post;
import org.example.board.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping
    public String list(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "posts/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "posts/detail";
    }

    @GetMapping("/new")
    public String newPost(Model model) {
        model.addAttribute("post", new PostDto());
        return "posts/form";
    }

    @PostMapping
    public String create(@ModelAttribute Post post) {
        postService.createPost(post);
        return "redirect:/posts";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.getPostById(id));
        return "posts/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Post post) {
        postService.updatePost(id, post);
        return "redirect:/posts/" + id;
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/posts";
    }
}
