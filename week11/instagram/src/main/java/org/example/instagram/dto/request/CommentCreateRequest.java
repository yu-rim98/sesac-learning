package org.example.instagram.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentCreateRequest {

    @NotBlank(message = "댓글을 입력해주세요.")
    @Size(max = 500, message = "최대 500자까지만 작성 가능합니다. ")
    private String content;
}
