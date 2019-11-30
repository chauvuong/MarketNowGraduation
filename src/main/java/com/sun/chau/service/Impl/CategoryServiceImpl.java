package com.sun.chau.service.Impl;

import com.sun.chau.entity.Category;
import com.sun.chau.repository.CategoryRepository;
import com.sun.chau.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public List<Category> getAll() {
    return (List<Category>) categoryRepository.findAll();
  }
  @Override
  public Optional<Category> getCategoryById(int id) {
    return categoryRepository.findById(id);
  }

}
