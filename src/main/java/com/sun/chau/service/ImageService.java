package com.sun.chau.service;

import com.sun.chau.entity.Image;

import java.util.List;

public interface ImageService {
    public List<Image> getAll();
    public Image getImageById(int id);
    public Image addImage(Image image);
    public List<Image> addImages(List<Image> images);
    public Boolean deleteImage(int id);
}
