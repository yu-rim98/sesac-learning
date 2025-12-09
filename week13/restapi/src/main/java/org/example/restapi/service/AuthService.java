package org.example.restapi.service;

import org.example.restapi.dto.request.LoginReq;
import org.example.restapi.dto.request.SignupReq;
import org.example.restapi.dto.response.TokenResponse;
import org.example.restapi.dto.response.UserResponse;

public interface AuthService {

    UserResponse signup(SignupReq req);

    TokenResponse login(LoginReq req);
}
