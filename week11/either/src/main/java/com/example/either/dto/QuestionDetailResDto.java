package com.example.either.dto;

import com.example.either.entity.Answer;
import com.example.either.entity.Question;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Getter;


@Getter
public class QuestionDetailResDto {

    private Long id;
    private String title;
    private String optionA;
    private String optionB;

    private long countA;
    private long countB;
    private List<AnswerResDto> answers;

    @Builder
    private QuestionDetailResDto(Long id, String title, String optionA, String optionB, long countA,
        long countB, List<AnswerResDto> answers) {
        this.id = id;
        this.title = title;
        this.optionA = optionA;
        this.optionB = optionB;
        this.countA = countA;
        this.countB = countB;
        this.answers = answers;
    }

    public static QuestionDetailResDto of(Question question, List<Answer> answers) {
        int TotalCountA = 0;
        int TotalCountB = 0;

        List<AnswerResDto> answerResDtos = new ArrayList<>();

        for (Answer answer : answers) {
            answerResDtos.add(AnswerResDto.toDto(answer));

            if ("A".equals(answer.getAnswerText())) {
                TotalCountA++;
            } else if ("B".equals(answer.getAnswerText())) {
                TotalCountB++;
            }
        }

        return QuestionDetailResDto.builder()
            .id(question.getId())
            .title(question.getTitle())
            .optionA(question.getOptionA())
            .optionB(question.getOptionB())
            .countA(TotalCountA)
            .countB(TotalCountB)
            .answers(answerResDtos)
            .build();
    }
}
