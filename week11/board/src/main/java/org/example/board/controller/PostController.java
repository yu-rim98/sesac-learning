package org.example.board.controller;

import lombok.RequiredArgsConstructor;
import org.example.board.dto.PostDto;
import org.example.board.repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostRepository postRepository;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        return "posts/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        PostDto post = postRepository.findById(id);
        model.addAttribute("post", post);
        return "posts/detail";
    }
}
