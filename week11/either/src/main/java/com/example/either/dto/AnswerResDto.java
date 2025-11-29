package com.example.either.dto;

import com.example.either.entity.Answer;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AnswerResDto {
    private final String answerText;
    private final String content;

    public static AnswerResDto toDto(Answer answer) {
        return new AnswerResDto(answer.getAnswerText(), answer.getContent());
    }

}
