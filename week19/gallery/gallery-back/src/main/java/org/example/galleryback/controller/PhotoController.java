package org.example.galleryback.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.galleryback.dto.request.PhotoRequest;
import org.example.galleryback.dto.response.PhotoResponse;
import org.example.galleryback.service.PhotoService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/photos")
public class PhotoController {

    private final PhotoService photoService;

    @GetMapping
    public List<PhotoResponse> findAll() {
        return photoService.findAll();
    }

    @GetMapping("/{photoId}")
    public PhotoResponse findById(@PathVariable Long photoId) {
        return photoService.findById(photoId);
    }

    @PostMapping
    public PhotoResponse upload(@Valid @ModelAttribute PhotoRequest request) {
        return photoService.save(request);
    }

    @DeleteMapping("/{photoId}")
    public void delete(@PathVariable Long photoId) {
        photoService.delete(photoId);
    }

}
