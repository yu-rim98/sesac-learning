package org.example.instagram.service;

import org.example.instagram.dto.request.ProfileUpdateRequest;
import org.example.instagram.dto.response.ProfileResponse;
import org.springframework.web.multipart.MultipartFile;

public interface ProfileService {

    ProfileResponse getProfile(String username);
    ProfileUpdateRequest getProfileForUpdate(Long userId);
    void updateProfile(ProfileUpdateRequest request, Long userId, MultipartFile profileImg);
}
