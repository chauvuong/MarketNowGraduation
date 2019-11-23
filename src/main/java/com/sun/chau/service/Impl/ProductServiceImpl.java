package com.sun.chau.service.Impl;

import com.sun.chau.entity.Product;
import com.sun.chau.repository.ProductRepository;
import com.sun.chau.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
  @Autowired
  private ProductRepository productRepository;
  @Override
  public List<Product> getAll() {
    return (List<Product>) productRepository.findAll();
  }
}
