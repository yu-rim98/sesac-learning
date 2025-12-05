package org.example.instagram.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // 400
    SELF_FOLLOW(HttpStatus.BAD_REQUEST, "자기 자신은 팔로우할 수 없습니다."),

    // 404
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 사용자입니다."),
    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 게시물입니다.")
    ;

    private final HttpStatus httpStatus;
    private final String message;
}
