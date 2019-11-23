package com.sun.chau.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Image {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private int id;
  private String name;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;
}
