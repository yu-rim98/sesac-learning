package com.example.either.service;

import com.example.either.dto.QuestionDetailResDto;
import com.example.either.dto.QuestionReqDto;
import com.example.either.dto.QuestionResDto;
import com.example.either.entity.Answer;
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
    public Question createQuestion(QuestionReqDto questionReqDto) {
        validationQuestion(questionReqDto);

        return questionRepository.save(questionReqDto.toEntity());
    }

    public List<QuestionResDto> getQuestions() {
        List<Question> questions = questionRepository.findAll();
        return questions.stream()
            .map(QuestionResDto::toDto)
            .toList();
    }

    public QuestionDetailResDto getQuestionDetail(Long id) {
        Question question = getQuestionOrThrow(id);
        List<Answer> answers = question.getAnswers();

        return QuestionDetailResDto.of(question, answers);
    }


    public Question getRandomQuestion() {
        return questionRepository.findRandomQuestion();
    }

    private void validationQuestion(QuestionReqDto reqDto) {
        if (reqDto.getTitle().length() > 200) {
            throw new IllegalArgumentException("제목은 200자를 넘길 수 없습니다.");
        }

        if (reqDto.getOptionA().length() > 200 || reqDto.getOptionB().length() > 200) {
            throw new IllegalArgumentException("선택지는 200자를 넘길 수 없습니다.");
        }
    }

    private Question getQuestionOrThrow(Long id) {
        return questionRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 질문입니다."));
    }
}
