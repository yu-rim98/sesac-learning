package org.example.instagram.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

//    private final PostService postService;

//    @GetMapping
//    public String home(Model model) {
//        model.addAttribute("posts", postService.getAllPostsWithStats());
//        return "home";
//    }

    @GetMapping
    public String home() {
        return "home";
    }

    @GetMapping("/explore")
    public String explore() {
        return "explore";
    }
}
