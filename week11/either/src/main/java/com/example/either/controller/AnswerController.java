package com.example.either.controller;

import com.example.either.dto.AnswerReqDto;
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
    public String createAnswer(@PathVariable Long questionId, @ModelAttribute AnswerReqDto answerReqDto) {
        answerService.createAnswer(answerReqDto, questionId);
        return "redirect:/questions/detail/" + questionId;
    }



}
