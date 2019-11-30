package com.sun.chau.service.Impl;

import com.sun.chau.entity.Image;
import com.sun.chau.repository.ImageRepository;
import com.sun.chau.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;
    @Override
    public List<Image> getAll() {
        return (List<Image>) imageRepository.findAll();
    }

    @Override
    public Optional<Image> getImageById(int id) {
        return imageRepository.findById(id);
    }

    @Override
    public Image addImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public List<Image> addImages(List<Image> images) {
        return (List<Image>) imageRepository.saveAll(images);
    }

    @Override
    public Boolean deleteImage(int id) {
        imageRepository.deleteById(id);
        return true;
    }

}
