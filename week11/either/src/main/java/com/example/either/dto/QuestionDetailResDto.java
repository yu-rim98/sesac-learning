package com.example.either.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class QuestionDetailResDto {

    private final Long id;
    private final String title;
    private final String optionA;
    private final String optionB;

    private final long countA;
    private final long countB;
    private final List<AnswerResDto> answers;

}
