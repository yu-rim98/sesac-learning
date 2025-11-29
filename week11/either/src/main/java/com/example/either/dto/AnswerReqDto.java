package com.example.either.dto;

import com.example.either.entity.Answer;
import com.example.either.entity.Question;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerReqDto {

    private String answerText;

    private String content;

    public Answer toEntity(Question question) {
        return new Answer(this.answerText, this.content, question);
    }
}
