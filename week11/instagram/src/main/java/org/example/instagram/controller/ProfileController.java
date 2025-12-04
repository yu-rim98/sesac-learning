package org.example.instagram.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.instagram.dto.request.ProfileUpdateRequest;
import org.example.instagram.dto.response.UserResponse;
import org.example.instagram.security.CustomUserDetails;
import org.example.instagram.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final UserService userService;

    @GetMapping("/edit")
    public String editForm(Model model, @AuthenticationPrincipal CustomUserDetails userDetails) {

        ProfileUpdateRequest request = userService.getProfileForUpdate(userDetails.getId());
        UserResponse userResponse = userService.getUserById(userDetails.getId());

        model.addAttribute("profileUpdateRequest", request);
        model.addAttribute("currentUser", userResponse);
        return "profile/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute ProfileUpdateRequest request,
        BindingResult bindingResult,
        Model model,
        @AuthenticationPrincipal CustomUserDetails userDetails) {

        if (bindingResult.hasErrors()) {
            ProfileUpdateRequest updateRequest = userService.getProfileForUpdate(
                userDetails.getId());
            UserResponse userResponse = userService.getUserById(userDetails.getId());

            model.addAttribute("profileUpdateRequest", updateRequest);
            model.addAttribute("currentUser", userResponse);
            return "profile/edit";
        }

        userService.updateProfile(request, userDetails.getId());

        return "redirect:/profile/edit";
    }
}
