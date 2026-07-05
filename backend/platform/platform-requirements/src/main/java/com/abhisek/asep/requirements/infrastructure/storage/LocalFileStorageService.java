package com.abhisek.asep.requirements.infrastructure.storage;

import com.abhisek.asep.requirements.application.storage.FileStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class LocalFileStorageService implements FileStorageService {

    private final Path rootLocation;

    public LocalFileStorageService(@Value("${asep.storage.location:uploads}") String location) throws IOException {

        this.rootLocation = Paths.get(location);

        Files.createDirectories(rootLocation);
    }

    @Override
    public String store(MultipartFile file) {

        try {

            String extension = "";

            String originalName = StringUtils.cleanPath(file.getOriginalFilename());

            int index = originalName.lastIndexOf('.');

            if (index > 0) {
                extension = originalName.substring(index);
            }

            String storedName = UUID.randomUUID() + extension;

            Files.copy(file.getInputStream(), rootLocation.resolve(storedName), StandardCopyOption.REPLACE_EXISTING);

            return storedName;

        } catch (IOException ex) {

            throw new RuntimeException("Unable to store attachment", ex);

        }
    }

    @Override
    public Resource load(String storagePath) {

        try {

            Path file = rootLocation.resolve(storagePath);

            Resource resource = new UrlResource(file.toUri());

            if (!resource.exists()) {
                throw new RuntimeException("Attachment not found");
            }

            return resource;

        } catch (MalformedURLException ex) {

            throw new RuntimeException("Unable to load attachment", ex);

        }

    }

    @Override
    public void delete(String storagePath) {

        try {

            Files.deleteIfExists(rootLocation.resolve(storagePath));

        } catch (IOException ex) {

            throw new RuntimeException("Unable to delete attachment", ex);

        }

    }

}