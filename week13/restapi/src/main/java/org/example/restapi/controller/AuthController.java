package org.example.restapi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.restapi.dto.request.LoginReq;
import org.example.restapi.dto.request.SignupReq;
import org.example.restapi.dto.response.ApiResponse;
import org.example.restapi.dto.response.TokenResponse;
import org.example.restapi.dto.response.UserResponse;
import org.example.restapi.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<UserResponse>> signup(@Valid @RequestBody SignupReq req) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(ApiResponse.success(authService.signup(req)));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<TokenResponse>> login(@Valid @RequestBody LoginReq req) {
        return ResponseEntity.ok(ApiResponse.success(authService.login(req)));
    }
}
