package com.example.either.controller;

import com.example.either.dto.QuestionDto;
import com.example.either.entity.Question;
import com.example.either.service.QuestionService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/new")
    public String getForm(Model model) {
        model.addAttribute("questionDto", new QuestionDto());
        return "questions/form";
    }

    @PostMapping
    public String createQuestion(@ModelAttribute Question question, Model model) {
        Question savedQuestion = questionService.createQuestion(question);
        model.addAttribute("question", savedQuestion);
        return "questions/detail"; //TODO 상세조회로 보내기
    }

    @GetMapping
    public String getQuestions(Model model) {
        List<Question> questions = questionService.getQuestions();
        model.addAttribute("questions", questions);
        return "questions/list";
    }
}
