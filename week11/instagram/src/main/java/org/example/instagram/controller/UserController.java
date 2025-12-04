package org.example.instagram.controller;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;
import org.example.instagram.dto.response.ProfileResponse;
import org.example.instagram.security.CustomUserDetails;
import org.example.instagram.service.FollowService;
import org.example.instagram.service.PostService;
import org.example.instagram.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PostService postService;
    private final FollowService followService;

    @GetMapping("/{username}")
    public String profile(@PathVariable String username, Model model, @AuthenticationPrincipal
    CustomUserDetails userDetails) {

        ProfileResponse profile = userService.getProfile(username);

        model.addAttribute("profile", profile);
        model.addAttribute("posts", postService.getPostsByUsername(username));
        model.addAttribute("isFollowing",
            followService.isFollowing(userDetails.getId(), profile.getId()));

        return "user/profile";
    }

    @PostMapping("/{username}/follow")
    public String toggleFollow(@PathVariable String username,
        @AuthenticationPrincipal CustomUserDetails userDetails) {
        followService.toggleFollow(username, userDetails.getId());
        String encodedUsername = URLEncoder.encode(username, StandardCharsets.UTF_8);
        return "redirect:/users/" + encodedUsername;
    }
}
