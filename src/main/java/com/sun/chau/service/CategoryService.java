package com.sun.chau.service;

import com.sun.chau.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
  List<Category> getAll();
  public Optional<Category> getCategoryById(int id);
}
