package com.sun.chau.service;

import com.sun.chau.entity.OrderProduct;
import com.sun.chau.entity.Product;

import java.util.List;
import java.util.Optional;

public interface OrderProductService {
  public List<OrderProduct> getAll();
  public List<OrderProduct> findAllByAccountId(int accountId);
  public List<OrderProduct> findAllByShipperId(int shipperId);
  public Optional<OrderProduct> getOrderProductById(int id);
}
