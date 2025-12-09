package org.example.restapi.service;

import lombok.RequiredArgsConstructor;
import org.example.restapi.dto.request.LoginReq;
import org.example.restapi.dto.request.SignupReq;
import org.example.restapi.dto.response.TokenResponse;
import org.example.restapi.dto.response.UserResponse;
import org.example.restapi.entity.User;
import org.example.restapi.exception.CustomException;
import org.example.restapi.exception.ErrorCode;
import org.example.restapi.repository.UserRepository;
import org.example.restapi.secutity.JwtProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Override
    @Transactional
    public UserResponse signup(SignupReq req) {
        if (userRepository.existsByUsername(req.getUsername())) {
            throw new CustomException(ErrorCode.DUPLICATE_USERNAME);
        }

        String encodedPassword = passwordEncoder.encode(req.getPassword());

        User user = User.of(req.getUsername(), encodedPassword, req.getEmail(), req.getName());

        return UserResponse.from(userRepository.save(user));
    }

    @Override
    public TokenResponse login(LoginReq req) {
        User user = userRepository.findByUsername(req.getUsername())
            .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
            throw new CustomException(ErrorCode.INVALID_PASSWORD);
        }

        String accessToken = jwtProvider.createToken(user.getUsername());

        return TokenResponse.of(accessToken);
    }
}
