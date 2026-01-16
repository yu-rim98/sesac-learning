package org.example.galleryback.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class PhotoRequest {

    @NotBlank
    private String title;

    private String description;
}
