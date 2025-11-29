package com.example.either.controller;

import com.example.either.dto.QuestionReqDto;
import com.example.either.entity.Question;
import com.example.either.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/new")
    public String getForm(Model model) {
        model.addAttribute("questionDto", new QuestionReqDto());
        return "questions/form";
    }

    @PostMapping
    public String createQuestion(@ModelAttribute QuestionReqDto questionReqDto, Model model) {
        Question savedQuestion = questionService.createQuestion(questionReqDto);
        model.addAttribute("question", savedQuestion);
        return "redirect:/questions/detail/" + savedQuestion.getId();
    }

    @GetMapping
    public String getQuestions(Model model) {
        model.addAttribute("questions", questionService.getQuestions());
        return "questions/list";
    }

    @GetMapping("/detail/{id}")
    public String getQuestion(@PathVariable Long id, Model model) {
        model.addAttribute("questionDetail", questionService.getQuestionDetail(id));

        return "/questions/detail";
    }

    @GetMapping("/random")
    public String getRandomQuestion() {
        Question question = questionService.getRandomQuestion();
        return "redirect:/questions/detail/" + question.getId();
    }
}
