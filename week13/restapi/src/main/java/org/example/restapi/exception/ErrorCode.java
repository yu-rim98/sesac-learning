package org.example.restapi.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    INVALID_INPUT(HttpStatus.BAD_REQUEST, "INVALID_INPUT", "잘못된 입력 값입니다."),
    INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_ERROR", "서버 오류가 발생했습니다."),

    // todo 에러
    TODO_NOT_FOUND(HttpStatus.NOT_FOUND, "TODO_NOT_FOUND", "존재하지 않는 Todo입니다."),

    // user 에러
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER_NOT_FOUND", "존재하지 않는 사용자입니다."),

    // auth 에러
    DUPLICATE_USERNAME(HttpStatus.CONFLICT, "DUPLICATE_USERNAME", "이미 존재하는 사용자명입니다."),
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "INVALID_PASSWORD", "비밀번호가 일치하지 않습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;
}
