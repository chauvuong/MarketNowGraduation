package com.sun.chau.controller;

import com.sun.chau.service.Impl.ProductServiceImpl;
import com.sun.chau.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @GetMapping
  public ResponseEntity getAllProduct() {
    return new ResponseEntity(productService.getAll(), HttpStatus.OK);
  }
}
