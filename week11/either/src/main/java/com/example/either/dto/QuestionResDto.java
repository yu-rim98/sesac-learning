package com.example.either.dto;

import com.example.either.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuestionResDto {

    private final Long id;
    private final String title;

    public static QuestionResDto toDto(Question question) {
        return new QuestionResDto(question.getId(), question.getTitle());
    }
}
