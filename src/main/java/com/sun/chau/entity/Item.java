package com.sun.chau.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private int id;
  private int quantity;

  @ManyToOne
  @JoinColumn(name = "order_product_id")
  private OrderProduct orderProduct;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private  Product product;
}
