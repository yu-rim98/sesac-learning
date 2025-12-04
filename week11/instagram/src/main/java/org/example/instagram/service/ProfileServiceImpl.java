package org.example.instagram.service;

import lombok.RequiredArgsConstructor;
import org.example.instagram.dto.request.ProfileUpdateRequest;
import org.example.instagram.dto.response.ProfileResponse;
import org.example.instagram.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService{

    private final UserService userService;
    private final PostService postService;
    private final FollowService followService;
    private final FileService fileService;

    @Override
    public ProfileResponse getProfile(String username) {
        User user = userService.findByUsername(username);
        long postCount = postService.countByUserId(user.getId());
        long followerCount = followService.countByFollowingId(user.getId());
        long followingCount = followService.countByFollowerId(user.getId());

        return ProfileResponse.from(user, postCount, followerCount, followingCount);
    }

    @Override
    public ProfileUpdateRequest getProfileForUpdate(Long userId) {
        User user = userService.findById(userId);
        ProfileUpdateRequest request = new ProfileUpdateRequest();
        request.setName(user.getName());
        request.setBio(user.getBio());
        return request;
    }

    @Override
    @Transactional
    public void updateProfile(ProfileUpdateRequest request, Long userId, MultipartFile profileImg) {
        User user = userService.findById(userId);

        if (profileImg != null && !profileImg.isEmpty()) {
            String filename = fileService.saveFile(profileImg);
            String imageUrl = "/uploads/" + filename;
            user.updateProfileImage(imageUrl);
        }

        user.updateProfile(request.getName(), request.getBio());
    }
}
