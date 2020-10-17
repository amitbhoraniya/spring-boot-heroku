package com.example.demo.controller;

import com.example.demo.entity.Image;
import com.example.demo.service.ImageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author amit.bhoraniya
 * @created 17/10/20
 */

@RestController
public class ImagesController {

    @Autowired
    ImageService imageService;

    @ResponseBody
    @GetMapping(produces = "image/jpeg")
    public byte[] getRandomImage() {
        return imageService.getRandomImage();
    }

    @ResponseBody
    @GetMapping(value = "/{imageId}", produces = "image/jpeg")
    public byte[] getImageById(@PathVariable("imageId") long imageId) {
        return imageService.getImageById(imageId);
    }

    @ResponseBody
    @GetMapping(value = "/images")
    public List<Image> getImages() {
        return imageService.getImages();
    }
}
