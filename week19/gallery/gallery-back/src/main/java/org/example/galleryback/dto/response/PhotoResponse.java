package org.example.galleryback.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.galleryback.entity.Photo;

@Getter
@RequiredArgsConstructor
public class PhotoResponse {

    private final Long id;
    private final String title;
    private final String description;
    private final String imageUrl;

    public static PhotoResponse from(Photo photo) {
        return new PhotoResponse(photo.getId(), photo.getTitle(), photo.getDescription(),
            photo.getImageUrl());
    }
}
