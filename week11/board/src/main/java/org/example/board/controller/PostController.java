package org.example.board.controller;

import lombok.RequiredArgsConstructor;
import org.example.board.dto.PostDto;
import org.example.board.entity.Post;
import org.example.board.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping
    public String list(Model model,
        @PageableDefault(size = 20, page = 0, sort = "id", direction = Direction.DESC) Pageable pageable) {
//        model.addAttribute("posts", postService.getAllPosts());
        Page<Post> postPage = postService.getPostsPage(pageable);
        model.addAttribute("postPage", postPage.getContent());
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


    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model) {
//        model.addAttribute("posts", postService.searchPosts(keyword));
        model.addAttribute("posts", postService.searchPostsByTitleOrContent(keyword));
        return "/posts/list";
    }


    @GetMapping("/test/cache")
    public String testCache() {
        postService.testFirstLevelCache();
        return "redirect:/posts";
    }

    @GetMapping("/test/write")
    public String testWrite() {
        postService.testWriteBehind();
        return "redirect:/posts";
    }

    // 최근 게시물 3개만 출력
    // /posts/recent
    @GetMapping("/recent")
    public String recentPosts(Model model) {
        model.addAttribute("posts", postService.getRecentPosts());
        return "/posts/list";
    }

    @GetMapping("/dummy")
    public String dummy() {
        postService.createDummyPosts(100);
        return "redirect:/posts";
    }
}
