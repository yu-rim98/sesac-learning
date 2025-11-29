package com.example.either.service;

import com.example.either.dto.AnswerReqDto;
import com.example.either.entity.Answer;
import com.example.either.entity.Question;
import com.example.either.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final QuestionService questionService;

    @Transactional
    public void createAnswer(AnswerReqDto answerReqDto, Long questionId) {
        Question question = questionService.getQuestion(questionId);

        validationAnswer(answerReqDto);

        Answer answer = answerReqDto.toEntity(question);
        question.addAnswer(answer);

        answerRepository.save(answer);
    }

    private void validationAnswer(AnswerReqDto answer) {
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
