package com.example.demo.service;

import com.example.demo.entity.Image;
import com.example.demo.repository.ImageRepository;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author amit.bhoraniya
 * @created 17/10/20
 */
@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public static final String photosURL = "https://picsum.photos/seed/%d/600/400";

    public byte[] getRandomImage() {
        int random = (int) (Math.random() * 1000 + 1);
        try {
            return IOUtils.toByteArray(new URL(String.format(photosURL, random)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] getImageById(long imageId) {
        try {
            String url = String.format(photosURL, imageId);
            if (!imageRepository.existsById(imageId)) {
                imageRepository.save(new Image(imageId, url));
            }
            return IOUtils.toByteArray(new URL(url));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Image> getImages() {
        return imageRepository.findAll();
    }
}
