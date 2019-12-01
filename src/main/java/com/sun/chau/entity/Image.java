package com.sun.chau.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@JsonFilter("filter.image")
public class Image {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private int id;
  private String name;
  private String path;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;
}
