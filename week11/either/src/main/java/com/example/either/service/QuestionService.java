package com.example.either.service;

import com.example.either.entity.Question;
import com.example.either.repository.QuestionRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Transactional
    public Question createQuestion(Question question) {
        validationQuestion(question);
        return questionRepository.save(question);
    }

    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestionById(Long id) {
        return questionRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 질문입니다."));
    }

    public Question getRandomQuestion() {
        return questionRepository.findRandomQuestion();
    }

    private void validationQuestion(Question question) {
        if (question.getTitle().length() > 200) {
            throw new IllegalArgumentException("제목은 200자를 넘길 수 없습니다.");
        }

        if (question.getOptionA().length() > 200 || question.getOptionB().length() > 200) {
            throw new IllegalArgumentException("선택지는 200자를 넘길 수 없습니다.");
        }
    }
}
