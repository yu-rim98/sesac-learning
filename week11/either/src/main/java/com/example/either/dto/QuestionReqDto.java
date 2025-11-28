package com.example.either.dto;

import com.example.either.entity.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QuestionReqDto {

    private String title;
    private String optionA;
    private String optionB;

    public Question toEntity() {
        return new Question(this.title, this.optionA, this.optionB);
    }
}
