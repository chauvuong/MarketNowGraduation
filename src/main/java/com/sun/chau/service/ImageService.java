package com.sun.chau.service;

import com.sun.chau.entity.Image;

import java.util.List;
import java.util.Optional;

public interface ImageService {
    public List<Image> getAll();
    public Optional<Image> getImageById(int id);
    public Image addImage(Image image);
    public List<Image> addImages(List<Image> images);
    public Boolean deleteImage(int id);
}
