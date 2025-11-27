package com.example.either.controller;

import com.example.either.dto.QuestionDto;
import com.example.either.entity.Answer;
import com.example.either.entity.Question;
import com.example.either.service.AnswerService;
import com.example.either.service.QuestionService;
import java.util.List;
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
    private final AnswerService answerService;

    @GetMapping("/new")
    public String getForm(Model model) {
        model.addAttribute("questionDto", new QuestionDto());
        return "questions/form";
    }

    @PostMapping
    public String createQuestion(@ModelAttribute Question question, Model model) {
        Question savedQuestion = questionService.createQuestion(question);
        model.addAttribute("question", savedQuestion);
        return "redirect:/questions/detail/" + savedQuestion.getId();
    }

    @GetMapping
    public String getQuestions(Model model) {
        List<Question> questions = questionService.getQuestions();
        model.addAttribute("questions", questions);
        return "questions/list";
    }

    @GetMapping("/detail/{id}")
    public String getQuestion(@PathVariable Long id, Model model) {
        Question question = questionService.getQuestionById(id);
        List<Answer> answers = question.getAnswers();

        long countA = answers.stream()
            .filter(answer -> answer.getAnswerText().equals("A"))
            .count();

        long countB = answers.stream()
            .filter(answer -> answer.getAnswerText().equals("B"))
            .count();

        model.addAttribute("question", question);
        model.addAttribute("answers", answers);
        model.addAttribute("countA", countA);
        model.addAttribute("countB", countB);

        return "/questions/detail";
    }

    @GetMapping("/random")
    public String getRandomQuestion() {
        Question question = questionService.getRandomQuestion();
        return "redirect:/questions/detail/" + question.getId();
    }
}
