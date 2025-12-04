package org.example.instagram.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.instagram.dto.request.ProfileUpdateRequest;
import org.example.instagram.dto.response.UserResponse;
import org.example.instagram.security.CustomUserDetails;
import org.example.instagram.service.ProfileService;
import org.example.instagram.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final UserService userService;
    private final ProfileService profileService;

    @GetMapping("/edit")
    public String editForm(Model model, @AuthenticationPrincipal CustomUserDetails userDetails) {

        ProfileUpdateRequest request = profileService.getProfileForUpdate(userDetails.getId());
        UserResponse userResponse = userService.getUserById(userDetails.getId());

        model.addAttribute("profileUpdateRequest", request);
        model.addAttribute("currentUser", userResponse);
        return "profile/edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute ProfileUpdateRequest request,
        BindingResult bindingResult,
        Model model,
        @AuthenticationPrincipal CustomUserDetails userDetails,
        @RequestParam(value = "profileImg", required = false)
        MultipartFile profileImg) {

        if (bindingResult.hasErrors()) {
            UserResponse userResponse = userService.getUserById(userDetails.getId());

            model.addAttribute("currentUser", userResponse);
            return "profile/edit";
        }

        profileService.updateProfile(request, userDetails.getId(), profileImg);

        return "redirect:/profile/edit";
    }
}
