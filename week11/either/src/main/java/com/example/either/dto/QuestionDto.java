package com.example.either.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class QuestionDto {

    private Long id;
    private String title;
    private String optionA;
    private String optionB;

}
