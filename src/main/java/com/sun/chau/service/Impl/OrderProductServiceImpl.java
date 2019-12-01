package com.sun.chau.service.Impl;

import com.sun.chau.entity.OrderProduct;
import com.sun.chau.repository.OrderProductRepository;
import com.sun.chau.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductServiceImpl implements OrderProductService {
  @Autowired
  private OrderProductRepository orderProductRepository;

  @Override
  public List<OrderProduct> getAll() {
    return (List<OrderProduct>) orderProductRepository.findAll();
  }

  @Override
  public List<OrderProduct> findAllByAccountId(int accountId) {
    return (List<OrderProduct>) orderProductRepository.findAllByAccountId(accountId);
  }

  @Override
  public List<OrderProduct> findAllByShipperId(int shipperId) {
    return (List<OrderProduct>) orderProductRepository.findAllByShipperId(shipperId);
  }

  @Override
  public OrderProduct getOrderProductById(int id) {
    return orderProductRepository.findOne(id);
  }
}
