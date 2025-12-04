package org.example.instagram.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    private static final List<String> ALLOWED_EXTENSIONS = Arrays.asList(".jpg", ".jpeg", ".png",
        ".gif");

    @Override
    public String upload(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            return null;
        }

        String filename = saveFile(file);

        return "/" + uploadDir + "/" + filename;
    }

    private String saveFile(MultipartFile file) {
        try {
            String extension = getExtension(file.getOriginalFilename());
            validationExtension(extension);

            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            String savedFileName = getSavedFileName(extension);

            Path filePath = uploadPath.resolve(savedFileName);
            Files.copy(file.getInputStream(), filePath);

            return savedFileName;

        } catch (IOException e) {
            throw new RuntimeException("파일 저장 중 오류");
        }
    }

    private String getExtension(String filename) {
        if (filename == null || !filename.contains(".")) {
            throw new RuntimeException("유효하지 않은 파일");
        }

        return filename.substring(filename.lastIndexOf("."));
    }

    private void validationExtension(String extension) {
        if (!ALLOWED_EXTENSIONS.contains(extension.toLowerCase())) {
            throw new RuntimeException("허용되지 않는 확장자");
        }
    }

    private String getSavedFileName(String extension) {
        return UUID.randomUUID() + extension;
    }
}
