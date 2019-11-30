package com.sun.chau.service;

import com.sun.chau.entity.Product;

import java.util.List;

public interface ProductService {
  public List<Product> getAll();
  public Product getDeal();
  public List<Product> findAllByCategoryId(int categoryId);
  public Product getProductById(int id);
}
