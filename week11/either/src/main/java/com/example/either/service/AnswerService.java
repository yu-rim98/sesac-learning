package com.example.either.service;

import com.example.either.entity.Answer;
import com.example.either.entity.Question;
import com.example.either.repository.AnswerRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionService questionService;

    public Answer createAnswer(Answer answer, Long questionId) {
        Question question = questionService.getQuestionById(questionId);
        validationAnswer(answer);
        answer.changeQuestion(question);

        return answerRepository.save(answer);
    }

    public List<Answer> getAnswers() {
        return answerRepository.findAll(); //TODO 정렬
    }

    private void validationAnswer(Answer answer) {
        if (answer.getAnswerText().isEmpty()) {
            throw new IllegalArgumentException("투표는 필수입니다.");
        }

        if (answer.getContent().isEmpty()) {
            throw new IllegalArgumentException("의견을 입력해주세요.");
        }

        if (answer.getContent().length() > 500) {
            throw new IllegalArgumentException("500자를 초과할 수 없습니다.");
        }
    }
}
