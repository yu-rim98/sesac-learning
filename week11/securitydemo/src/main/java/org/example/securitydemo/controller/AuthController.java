package org.example.securitydemo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.securitydemo.dto.SignupDto;
import org.example.securitydemo.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal UserDetails userDetails, Model model) {

        if (userDetails != null) {
            model.addAttribute("name", userDetails.getUsername());
            model.addAttribute("authorities", userDetails.getAuthorities());
            model.addAttribute("password", userDetails.getPassword());
        }

        return "dashboard";
    }

    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("signupDto", new SignupDto());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@Valid @ModelAttribute SignupDto signupDto, BindingResult bindingResult) {

        if (!signupDto.getPassword().equals(signupDto.getPasswordConfirm())) {
            bindingResult.rejectValue("passwordConfirm", "mismatch", "비밀번호가 일치하지 않습니다.");
        }

        // 검증 실패
        if (bindingResult.hasErrors()) {
            return "signup";
        }

        // DB 조회가 필요한 검증
        // ID 중복 체크
        if (userService.existsByUsername(signupDto.getUsername())) {
            bindingResult.rejectValue("username", "duplicate", "이미 존재하는 username입니다.");
            return "signup";
        }

        // email 중복 체크
        if (userService.existsByEmail(signupDto.getEmail())) {
            bindingResult.rejectValue("email", "duplicate", "이미 존재하는 email입니다.");
            return "signup";
        }

        // 검증 성공 -> 회원가입 처리
        userService.register(signupDto);

        return "redirect:/login";
    }
}
