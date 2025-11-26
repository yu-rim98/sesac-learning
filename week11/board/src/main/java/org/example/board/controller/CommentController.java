package org.example.board.controller;

import lombok.RequiredArgsConstructor;
import org.example.board.entity.Comment;
import org.example.board.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/posts/{postId}/comments")
public class CommentController {


    private final CommentService commentService;

    @PostMapping
    public String createComment(@PathVariable Long postId, @ModelAttribute Comment comment) {
        commentService.createComment(postId, comment);
        return "redirect:/posts/" + postId;
    }

}
