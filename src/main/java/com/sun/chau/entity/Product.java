package com.sun.chau.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Getter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@JsonFilter("filter.product")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private int id;
  private String name;
  private BigDecimal price;
  private String unit;
  private int stock;
  private String sku;
  private int rating;
  private BigDecimal realPrice;

  @Column(columnDefinition = "TEXT")
  private String description;

  @Column(columnDefinition = "TEXT")
  private String review;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

  @OneToMany(mappedBy = "product")
  private List<Image> images;

  @ManyToOne
  @JoinColumn(name = "shop_id")
  private Shop shop;

  @OneToMany(mappedBy = "product")
  private List<Item> items;

  @ManyToOne
  @JoinColumn(name = "brand_id")
  private Brand brand;
}
