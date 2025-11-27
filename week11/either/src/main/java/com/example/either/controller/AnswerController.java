package com.example.either.controller;

import com.example.either.entity.Answer;
import com.example.either.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/questions/{questionId}/answers")
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping
    public String createAnswer(@PathVariable Long questionId, @ModelAttribute Answer answer) {
        answerService.createAnswer(answer, questionId);
        return "redirect:/questions/detail/" + questionId;
    }



}
