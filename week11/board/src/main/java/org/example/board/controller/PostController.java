package org.example.board.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.board.dto.CommentDto;
import org.example.board.dto.PostDto;
import org.example.board.entity.Comment;
import org.example.board.entity.Post;
import org.example.board.service.CommentService;
import org.example.board.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
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
    private final CommentService commentService;

    @GetMapping
    public String list(Model model,
        @PageableDefault(size = 20, page = 0, sort = "id", direction = Direction.DESC) Pageable pageable) {
//        model.addAttribute("posts", postService.getAllPosts());
        Page<Post> postPage = postService.getPostsPage(pageable);

        int currentPage = postPage.getNumber();
        int totalPage = postPage.getTotalPages();
        int startPage = Math.max(0, currentPage - 5);
        int endPage = Math.min(totalPage - 1, currentPage + 5);

        model.addAttribute("postPage", postPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
//        model.addAttribute("posts", postPage.getContent());
        return "posts/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Post post = postService.getPostById(id);
//        List<Comment> comments = commentService.getCommentsByPostId(id);
        List<Comment> comments = postService.getCommentsById(id);

        model.addAttribute("post", post);
        model.addAttribute("comment", new CommentDto());
        model.addAttribute("comments", comments);

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
    public String search(@RequestParam String keyword, Model model,
        @PageableDefault(sort = "id") Pageable pageable) {
//        model.addAttribute("posts", postService.searchPosts(keyword));
        Page<Post> postPage = postService.searchPostsPage(keyword, pageable);

        int currentPages = postPage.getNumber();
        int totalPages = postPage.getTotalPages();
        int startPage = Math.max(0, currentPages - 5);
        int endPage = Math.min(totalPages - 1, currentPages + 5);

        model.addAttribute("postPage", postPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("keyword", keyword);

        return "/posts/search";
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

    @GetMapping("/more")
    public String more(@PageableDefault Pageable pageable, Model model) {
        Slice<Post> postSlice = postService.getPostsSlice(pageable);
        model.addAttribute("postSlice", postSlice);

        return "/posts/list-more";
    }

}
