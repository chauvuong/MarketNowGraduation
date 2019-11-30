package com.sun.chau.service.Impl;

import com.sun.chau.entity.Product;
import com.sun.chau.repository.ProductRepository;
import com.sun.chau.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
  @Autowired
  private ProductRepository productRepository;
  @Override
  public List<Product> getAll() {
    return (List<Product>) productRepository.findAll(Sort.by(Sort.Direction.DESC, "rating"));
  }
  public Product getDeal() {
    return productRepository.findAll(Sort.by(Sort.Direction.DESC, "realPrice","rating")).get(0);
  }
  @Override
  public List<Product> findAllByCategoryId(int categoryId) {
    if(categoryId==1) return (List<Product>) productRepository.findAll(Sort.by(Sort.Direction.DESC, "rating"));
    return productRepository.findAllByCategoryId(categoryId);
  }

  @Override
  public Product getProductById(int id) {
    return (Product) productRepository.findAll().get(id);
  }
}
