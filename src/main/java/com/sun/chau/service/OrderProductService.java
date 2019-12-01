package com.sun.chau.service;

import com.sun.chau.entity.OrderProduct;

import java.util.List;

public interface OrderProductService {
  List<OrderProduct> getAll();
  List<OrderProduct> findAllByAccountId(int accountId);
  List<OrderProduct> findAllByShipperId(int shipperId);
  OrderProduct getOrderProductById(int id);
}
