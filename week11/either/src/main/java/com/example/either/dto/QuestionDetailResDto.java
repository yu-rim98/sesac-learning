package com.example.either.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class QuestionDetailResDto {

    private Long id;
    private String title;
    private String optionA;
    private String optionB;

    private long countA;
    private long countB;
    private List<AnswerResDto> answers;

}
