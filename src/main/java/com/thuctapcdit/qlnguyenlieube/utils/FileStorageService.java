package com.thuctapcdit.qlnguyenlieube.utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.thuctapcdit.qlnguyenlieube.config.FileStorageProperties;
import com.thuctapcdit.qlnguyenlieube.exception.FileNotFoundException;
import com.thuctapcdit.qlnguyenlieube.exception.FileStorageException;
@Service
public class FileStorageService {

    private final Path fileStorageLocation;

    // tao thu muc luu tru
    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public String storeFile(MultipartFile file , boolean isVideo) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            Path targetLocation = null;
            // Copy file to the target location (Replacing existing file with the same name)
            if(isVideo == true){
                targetLocation = this.fileStorageLocation.resolve("videos");

            }else {
                targetLocation = this.fileStorageLocation.resolve("images");
            }

            Files.copy(file.getInputStream(), targetLocation.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Resource loadFileAsResource(String fileName , boolean isVideo) {
        Path filePath = null;
        try {
            if (isVideo == true) {
                // fileStorageLocation = thư mục , resolve để nối đường dẫn
                filePath = this.fileStorageLocation.resolve("videos").resolve(fileName).normalize();
            } else {
                filePath = this.fileStorageLocation.resolve("images").resolve(fileName).normalize();
            }

            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new FileNotFoundException("File not found " + fileName, ex);
        }
    }
}
