package org.example.galleryback.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class PhotoRequest {

    @NotBlank
    private String title;

    private String description;

    @NotNull
    private MultipartFile file;
}
