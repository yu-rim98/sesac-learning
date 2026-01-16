package org.example.galleryback.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.example.galleryback.dto.request.PhotoRequest;
import org.example.galleryback.dto.response.PhotoResponse;
import org.example.galleryback.entity.Photo;
import org.example.galleryback.repository.PhotoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PhotoService {

    private final PhotoRepository photoRepository;
    private final FileStorageService fileStorageService;

    public List<PhotoResponse> findAll() {
        return photoRepository.findAll().stream()
            .map(PhotoResponse::from)
            .toList();
    }

    public PhotoResponse findById(Long photoId) {
        return PhotoResponse.from(photoRepository.findById(photoId)
            .orElseThrow(() -> new IllegalArgumentException("사진이 존재하지 않습니다.")));
    }

    @Transactional
    public PhotoResponse save(PhotoRequest request, MultipartFile file) {
        String imageUrl = fileStorageService.upload(file);

        return PhotoResponse.from(photoRepository.save(Photo.builder()
            .title(request.getTitle())
            .description(request.getDescription())
            .imageUrl(imageUrl)
            .build()));
    }

    @Transactional
    public void delete(Long photoId) {
        Photo photo = photoRepository.findById(photoId)
            .orElseThrow(() -> new IllegalArgumentException("사진이 존재하지 않습니다."));

        fileStorageService.delete(photo.getImageUrl());

        photoRepository.delete(photo);
    }
}
