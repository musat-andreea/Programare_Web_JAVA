package com.andreea.proiectjavafacultate.controllers;

import com.andreea.proiectjavafacultate.services.ImageService;
import com.andreea.proiectjavafacultate.models.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ImageController {
    @Autowired
    private ImageService imageService;


    @RequestMapping(value = "/images")
    public List<Image> getAllImages()
    {
        return imageService.getAllImages();
    }

    @RequestMapping(value = "/image/{id}")
    public Image getImageById(@PathVariable int id)
    {
        return imageService.getImage(id);
    }

    @RequestMapping(value = "/modelImage/{modelId}")
    public List<Image> getModelImage(@PathVariable int modelId)
    {
        return imageService.getModelImage(modelId);
    }

    @RequestMapping(value = "/addImage", method = RequestMethod.POST)
    public boolean addImage(@RequestBody Image c)
    {
        return imageService.addImage(c);
    }

    @RequestMapping(value = "/delImage/{id}", method = RequestMethod.POST)
    public boolean deleteImage(@PathVariable int id)
    {
        return imageService.deleteImage(id);
    }

}
