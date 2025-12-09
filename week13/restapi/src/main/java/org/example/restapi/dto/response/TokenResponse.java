package org.example.restapi.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TokenResponse {

    private static final String TOKEN_TYPE_STR = "Bearer";

    private String accessToken;
    private String tokenType;

    public static TokenResponse of(String accessToken) {
        return new TokenResponse(accessToken, TOKEN_TYPE_STR);
    }
}
